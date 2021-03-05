package bonus.problem;

import bonus.destination.Destination;
import bonus.solution.Solution;
import bonus.solution.SolutionPair;
import bonus.source.Factory;
import bonus.source.Source;

import java.util.Arrays;
import java.util.Vector;

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

    public Problem() {
        int numberOfSources, numberOfDestinations, totalCostSources = 0;
        numberOfSources = (int) (Math.random() * 10) + 1;
        numberOfDestinations = (int) (Math.random() * 10) + 1;

        Source[] sources = new Source[numberOfSources];
        Destination[] destinations = new Destination[numberOfDestinations];
        int[][] cost = new int[numberOfSources][numberOfDestinations];

        for (int i = 0; i < numberOfSources; i++) {
            int randomSourceSupply = (int) (Math.random() * 100 + 10);
            sources[i] = new Factory("s" + i, randomSourceSupply);
            totalCostSources += randomSourceSupply;
        }

        for (int i = 0; i < numberOfDestinations - 1; i++) {
            int randomDestinationDemand = (int) (Math.random() * (totalCostSources / 2) + 1);
            totalCostSources -= randomDestinationDemand;
            destinations[i] = new Destination("d" + i, randomDestinationDemand);
        }
        destinations[destinations.length - 1] = new Destination("d" + (destinations.length - 1), totalCostSources);

        for (int i = 0; i < numberOfSources; i++)
            for (int j = 0; j < numberOfDestinations; j++)
                cost[i][j] = (int) (Math.random() * 10 + 1);

        this.sources = sources;
        this.destinations = destinations;
        this.cost = cost;
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
     * Calculates the penalty cost for a specified line in the matrix of cost.
     *
     * @param line                 the line which we want to calculate the penalty
     * @param fullDestination      boolean vector of destinations which tells us if a destination is satisfied
     * @param noOfFullDestinations the number of destinations which are satisfied
     * @return returns the penalty cost for the specified line
     */
    private int calculatePenaltyLine(int line, boolean[] fullDestination, int noOfFullDestinations) {
        if (noOfFullDestinations + 1 == fullDestination.length) { // daca am o singura destinatie nesatisfacuta
            for (int i = 0; i < fullDestination.length; i++)
                if (!fullDestination[i]) {
                    return cost[line][i];
                }
        } else {
            int firstMinimum = 999999999, secondMinimum = 999999999;
            for (int i = 0; i < fullDestination.length; i++)
                if (!fullDestination[i]) {
                    if (cost[line][i] < firstMinimum) {
                        secondMinimum = firstMinimum;
                        firstMinimum = cost[line][i];
                    } else if (cost[line][i] < secondMinimum)
                        secondMinimum = cost[line][i];
                }
            return Math.abs(firstMinimum - secondMinimum);
        }
        return -999;
    }

    /**
     * Calculates the penalty cost for a specified column in the matrix of cost.
     *
     * @param column           the column which we want to calculate the penalty
     * @param emptySources     boolean vector of sources which tells us if a source is empty or not
     * @param noOfEmptySources the number of empty sources
     * @return returns the penalty cost for the specified column
     */
    private int calculatePenaltyColumn(int column, boolean[] emptySources, int noOfEmptySources) {
        if (noOfEmptySources + 1 == emptySources.length) { // daca am o singura sursa negolita
            for (int i = 0; i < emptySources.length; i++)
                if (!emptySources[i]) {
                    return cost[i][column];
                }
        } else {
            int firstMinimum = 999999999, secondMinimum = 999999999;
            for (int i = 0; i < emptySources.length; i++)
                if (!emptySources[i]) {
                    if (cost[i][column] < firstMinimum) {
                        secondMinimum = firstMinimum;
                        firstMinimum = cost[i][column];
                    } else if (cost[i][column] < secondMinimum)
                        secondMinimum = cost[i][column];
                }
            return Math.abs(firstMinimum - secondMinimum);
        }
        return -999;
    }

    /**
     * Function which returns a pair with the maximum penalty from a line of the matrix and its index.
     *
     * @param fullDestination      boolean vector of destinations which tells us if a destination is satisfied
     * @param noOfFullDestinations the number of destinations which are satisfied
     * @param emptySources         boolean vector of sources which tells us if a source is empty or not
     * @return a pair with the maximum penalty from a line of the matrix and its index.
     */
    private PenaltyPair getMaximumPenaltyOnLineIndex(boolean[] fullDestination, int noOfFullDestinations, boolean[] emptySources) {
        int maximum = -9999999;
        int index = 0;
        for (int i = 0; i < emptySources.length; i++) {
            if (!emptySources[i]) {
                int value = calculatePenaltyLine(i, fullDestination, noOfFullDestinations);
                if (value > maximum) {
                    maximum = value;
                    index = i;
                }
            }
        }
        return new PenaltyPair(maximum, index);
    }

    /**
     * Function which returns a pair with the maximum penalty from a column of the matrix and its index
     *
     * @param emptySources     boolean vector of sources which tells us if a source is empty or not
     * @param noOfEmptySources the number of empty sources
     * @param fullDestination  boolean vector of destinations which tells us if a destination is satisfied
     * @return a pair with the maximum penalty from a column of the matrix and its index
     */
    private PenaltyPair getMaximumPenaltyOnColumnIndex(boolean[] emptySources, int noOfEmptySources, boolean[] fullDestination) {
        int maximum = -99999999;
        int index = 0;
        for (int i = 0; i < fullDestination.length; i++) {
            if (!fullDestination[i]) {
                int value = calculatePenaltyColumn(i, emptySources, noOfEmptySources);
                if (value > maximum) {
                    maximum = value;
                    index = i;
                }
            }

        }
        return new PenaltyPair(maximum, index);
    }

    /**
     * This function calculates the minimum cost from a specified source to all the destinations that are not satisfied
     *
     * @param line            the index of the source which we want to calculate the minimum cost
     * @param fullDestination boolean vector of destinations which tells us if a destination is satisfied
     * @return the index of the destination(not satisfied) with the minimum cost from the specified source.
     */
    private int getMinimumIndexLine(int line, boolean[] fullDestination) {
        int minimum = 999999999, index = 0;
        for (int i = 0; i < fullDestination.length; i++)
            if (!fullDestination[i]) {
                if (cost[line][i] < minimum) {
                    minimum = cost[line][i];
                    index = i;
                }
            }
        return index;
    }

    /**
     * This function calculates the minimum cost from a specified destination to all the sources that are not empty
     *
     * @param column       the index of the destination which we want to calculate the minimum cost
     * @param emptySources boolean vector of sources which tells us if a source is empty or not
     * @return the index of the source(not empty) with the minimum cost from the specified destination.
     */
    private int getMinimumIndexColumn(int column, boolean[] emptySources) {
        int minimum = 99999999, index = 0;
        for (int i = 0; i < emptySources.length; i++)
            if (!emptySources[i]) {
                if (cost[i][column] < minimum) {
                    minimum = cost[i][column];
                    index = i;
                }
            }
        return index;
    }

    /**
     * This function solve the specified transport problem and and also offers the minimum total cost that can be generated from all possibilities.
     * <p>
     * This method is using the Vogel’s Approximation is an iterative procedure calculated to find out the initial feasible solution of the transportation problem.
     *
     * @return returns a new solution with the total cost and a vector of solution pairs which consists in:
     * <p>
     * 1. the source we transfer the units
     * <p>
     * 2. the destination to which we want to transfer the units
     * <p>
     * 3. the number of units taken from source
     * <p>
     * 4. the cost to transfer a single unit from source to destination.
     */
    public Solution solveProblem() {
        Vector<SolutionPair> solutionPairs = new Vector<SolutionPair>();
        int[] demands = getDemands(), supplies = getSupplies();
        boolean[] emptySources = new boolean[supplies.length], fullDestination = new boolean[demands.length];
        int totalCost = 0, noOfEmptySources = 0, noOfFullDestinations = 0;

        while ((noOfFullDestinations < fullDestination.length)) {
            PenaltyPair penaltyMaxLin = getMaximumPenaltyOnLineIndex(fullDestination, noOfFullDestinations, emptySources);
            PenaltyPair penaltyMaxCol = getMaximumPenaltyOnColumnIndex(emptySources, noOfEmptySources, fullDestination);

            int indexMinLin, indexMinCol, takeFromSource;

            if (penaltyMaxLin.getMaximum() > penaltyMaxCol.getMaximum()) {
                indexMinLin = penaltyMaxLin.getIndex();
                indexMinCol = getMinimumIndexLine(indexMinLin, fullDestination);
            } else {
                indexMinCol = penaltyMaxCol.getIndex();
                indexMinLin = getMinimumIndexColumn(indexMinCol, emptySources);
            }

            takeFromSource = Math.min(supplies[indexMinLin], demands[indexMinCol]);
            demands[indexMinCol] -= takeFromSource;
            supplies[indexMinLin] -= takeFromSource;

            if (supplies[indexMinLin] <= 0) {
                emptySources[indexMinLin] = true;
                noOfEmptySources++;
            }
            if (demands[indexMinCol] <= 0) {
                fullDestination[indexMinCol] = true;
                noOfFullDestinations++;
            }

            int currentCost = takeFromSource * cost[indexMinLin][indexMinCol];
            totalCost += currentCost;
            solutionPairs.add(new SolutionPair(sources[indexMinLin], destinations[indexMinCol], takeFromSource, cost[indexMinLin][indexMinCol]));
        }
        return new Solution(totalCost, solutionPairs);
    }
}