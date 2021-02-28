package optional;

import java.util.Vector;
import java.util.Arrays;

public class Problem {
    private int[][] cost;
    private Source[] sources;
    private Destionation[] destinations;

    public String toString() {
        String result = "Number Of Sources : " + this.sources.length + "\n";
        for (Source s : sources)
            result += s.toString() + "\n";

        result += "Number Of Destinations : " + this.destinations.length + "\n";
        for (Destionation d : destinations)
            result += d.toString() + "\n";

        result += "Matrix of Costs : " + cost.length + "x" + cost[0].length + "\n";

        String arrayString = Arrays.deepToString(cost).replaceAll("],", "],\n");
        result += arrayString;

        return result;
    }

    private boolean duplicateSource(Source s1, Source[] sources1) {
        int noOccurrences = 0;
        for (Source s : sources1)
            if (s == s1)
                noOccurrences++;
        return noOccurrences != 1;
    }

    private boolean duplicateDestination(Destionation d1, Destionation[] destinations1) {
        int noOccurrences = 0;
        for (Destionation d : destinations1)
            if (d == d1)
                noOccurrences++;
        return noOccurrences != 1;
    }

    private boolean noDuplicatesSources(Source[] sources1) {
        for (Source s : sources1)
            if (duplicateSource(s, sources1))
                return false;
        return true;
    }

    private boolean noDuplicatesDestinations(Destionation[] destinations1) {
        for (Destionation d : destinations1)
            if (duplicateDestination(d, destinations1))
                return false;
        return true;
    }


    public Problem(Source[] sources1, Destionation[] destinations1, int[][] cost1) {
        if (sources1.length != cost1.length || destinations1.length != cost1[0].length) {
            System.out.println("Numarul de surse si destinatii nu corespunde cu matricea data");
            System.exit(0);
        }

        if (!noDuplicatesSources(sources1) || !noDuplicatesDestinations(destinations1)) {
            System.out.println("Ai introdus duplicate pentru surse/destinatii");
            System.exit(0);
        }

        this.sources = sources1;
        this.destinations = destinations1;
        this.cost = cost1;
    }

    public void setCost(int[][] cost1) {
        this.cost = cost1;
    }

    public int[][] getCost() {
        return this.cost;
    }

    public void setSources(Source[] sources1) {
        if (!noDuplicatesSources(sources1)) {
            System.out.println("Ai introdus duplicate pentru surse");
            System.exit(0);
        }

        this.sources = sources1;
    }

    public Source[] getSources() {
        return this.sources;
    }

    public void setDestinations(Destionation[] destinations1) {

        if (!noDuplicatesDestinations(destinations1)) {
            System.out.println("Ai introdus duplicate pentru destinatii");
            System.exit(0);
        }
        this.destinations = destinations1;
    }

    public Destionation[] getDestinations() {
        return this.destinations;
    }

    private int[] getSupplys() {
        int[] result = new int[sources.length];
        for (int i = 0; i < result.length; i++)
            result[i] = sources[i].getSupply();
        return result;
    }

    private int[] getDemands() {
        int[] result = new int[destinations.length];
        for (int i = 0; i < result.length; i++)
            result[i] = destinations[i].getDemand();
        return result;
    }

    public Solution solveProblem() {
        Vector<SolutionPair> solutionPairs = new Vector<SolutionPair>();
        int[] demands = getDemands();
        int[] supplies = getSupplys();
        int totalCost = 0, sourceIndex = 0, takeFromSource = 0;

        for (int destinationIndex = 0; destinationIndex < demands.length; destinationIndex++) {
            while (demands[destinationIndex] > 0) {
                takeFromSource = Math.min(demands[destinationIndex], supplies[sourceIndex]);
                if (takeFromSource < 0) {
                    takeFromSource = demands[destinationIndex];
                }
                demands[destinationIndex] -= takeFromSource;
                supplies[sourceIndex] -= takeFromSource;
                int currentCost = takeFromSource * cost[sourceIndex][destinationIndex];
                totalCost += currentCost;
                solutionPairs.add(new SolutionPair(sources[sourceIndex], destinations[destinationIndex], takeFromSource, cost[sourceIndex][destinationIndex]));
                if (supplies[sourceIndex] <= 0)
                    sourceIndex++;
            }
        }
        return new Solution(totalCost, solutionPairs);
    }
}