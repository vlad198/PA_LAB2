package optional.problem;

import optional.solution.Solution;
import optional.solution.SolutionPair;
import optional.destination.Destination;
import optional.source.Source;

import java.util.Vector;
import java.util.Arrays;

public class Problem {
    private int[][] cost;
    private Source[] sources;
    private Destination[] destinations;


    /**
     * toString method overridden
     *
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        String result = "Number Of Sources : " + this.sources.length + "\n";
        for (Source s : sources)
            result += s.toString() + "\n";

        result += "Number Of Destinations : " + this.destinations.length + "\n";
        for (Destination d : destinations)
            result += d.toString() + "\n";

        result += "Matrix of Costs : " + cost.length + "x" + cost[0].length + "\n";

        String arrayString = Arrays.deepToString(cost).replaceAll("],", "],\n");
        result += arrayString;

        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return true, if this object is the same as the object argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Arrays.equals(cost, problem.cost) && Arrays.equals(sources, problem.sources) && Arrays.equals(destinations, problem.destinations);
    }

    /**
     * This functions tests if a given source it is found more than twice in an array of sources
     *
     * @param s1       the source with which to compare
     * @param sources1 the array of sources to find the specified source
     * @return true, if the source number of occurrences in the array is equal to 1; false otherwise
     */
    private boolean duplicateSource(Source s1, Source[] sources1) {
        int noOccurrences = 0;
        for (Source s : sources1)
            if (s.equals(s1))
                noOccurrences++;
        return noOccurrences != 1;
    }

    /**
     * This functions tests if a given destination it is found more than twice in an array of destinations
     *
     * @param d1            the destination with which to compare
     * @param destinations1 the array of destinations to find the specified source
     * @return true, if the destination number of occurrences in the array is equal to 1; false otherwise
     */
    private boolean duplicateDestination(Destination d1, Destination[] destinations1) {
        int noOccurrences = 0;
        for (Destination d : destinations1)
            if (d.equals(d1))
                noOccurrences++;
        return noOccurrences != 1;
    }

    /**
     * This function tests if a given array of sources has duplicates
     *
     * @param sources1 the array of sources to test
     * @return true, if the given array has no duplicates; false otherwise
     */
    private boolean noDuplicatesSources(Source[] sources1) {
        for (Source s : sources1)
            if (duplicateSource(s, sources1))
                return false;
        return true;
    }

    /**
     * This function tests if a given array of destinations has duplicates
     *
     * @param destinations1 the array of destinations to test
     * @return true, if the given array has no duplicates; false otherwise
     */
    private boolean noDuplicatesDestinations(Destination[] destinations1) {
        for (Destination d : destinations1)
            if (duplicateDestination(d, destinations1))
                return false;
        return true;
    }

    /**
     * Constructor
     *
     * @param sources1      the sources of the object instantiated
     * @param destinations1 the destinations of the object instantiated
     * @param cost1         the cost matrix of the object instantiated
     */
    public Problem(Source[] sources1, Destination[] destinations1, int[][] cost1) {
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


    /**
     * setter for the cost of the object
     *
     * @param cost1 cost to be set
     */
    public void setCost(int[][] cost1) {
        this.cost = cost1;
    }

    /**
     * getter for the cost of the object
     *
     * @return cost of the object
     */
    public int[][] getCost() {
        return this.cost;
    }

    /**
     * setter for the sources of the object
     *
     * @param sources1 sources to be set
     */
    public void setSources(Source[] sources1) {
        this.sources = sources1;
    }

    /**
     * getter for the sources of the object
     *
     * @return sources of the object
     */
    public Source[] getSources() {
        return this.sources;
    }

    /**
     * setter for the destinations of the object
     *
     * @param destinations1 destinations to be set
     */
    public void setDestinations(Destination[] destinations1) {
        this.destinations = destinations1;
    }

    /**
     * getter for the destinations of the object
     *
     * @return destinations of the object
     */
    public Destination[] getDestinations() {
        return this.destinations;
    }

    /**
     * This method gets all the supplies of the sources
     *
     * @return returns an array of supplies from all sources
     */
    private int[] getSupplies() {
        int[] result = new int[sources.length];
        for (int i = 0; i < result.length; i++)
            result[i] = sources[i].getSupply();
        return result;
    }

    /**
     * this method gets all the demands values of the destinations
     *
     * @return returns an array of demands values from all sources
     */
    private int[] getDemands() {
        int[] result = new int[destinations.length];
        for (int i = 0; i < result.length; i++)
            result[i] = destinations[i].getDemand();
        return result;
    }

    /**
     * This function solves the problem instantiated.
     * For every destination in the array of destinations
     * it will try to satisfy their demands using 1 or more sources.
     * <p>
     * Let's say we are at source 1 in the array. While this source
     * has at least 1 unit left, we will try to satisfy the destinations
     * from the first to the last. After we ran out of units for this
     * source, we are going to the next in the array and try to satisfy
     * all the destinations left with this one and so on.
     *
     * @return a solution for the problem(not optimal)
     */
    public Solution solveProblem() {
        Vector<SolutionPair> solutionPairs = new Vector<SolutionPair>();
        int[] demands = getDemands();
        int[] supplies = getSupplies();
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