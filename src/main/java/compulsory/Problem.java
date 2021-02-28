package compulsory;

import java.util.Vector;
import java.util.Arrays;

/**
 * Class for the representation of the problem
 */
public class Problem {
    private int[][] cost;
    private Source[] sources;
    private Destination[] destinations;

    /**
     * toString method overridden
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        String result = "Number Of Sources : " + this.sources.length + "\n";
        for (Source s : sources)
            result += s + "\n";

        result += "Number Of Destinations : " + this.destinations.length + "\n";
        for (Destination d : destinations)
            result += d + "\n";

        result += "Matrix of Costs : " + cost.length + "x" + cost[0].length + "\n";

        String arrayString = Arrays.deepToString(cost).replaceAll("],", "],\n");
        result += arrayString;

        return result;
    }

    /**
     * Constructor
     * @param sources1 vector of sources to be set
     * @param destinations1 vector of destinations to be set
     * @param cost1 matrix of costs to be set
     */
    Problem(Source[] sources1, Destination[] destinations1, int[][] cost1) {

        if (sources1.length != cost1.length || destinations1.length != cost1[0].length) {
            System.out.println("Numarul de surse si destinatii nu corespunde cu matricea data");
            System.exit(0);
        }

        this.sources = sources1;
        this.destinations = destinations1;
        this.cost = cost1;
    }

    /**
     * setter for the cost of the object
     * @param cost1 cost to be set
     */
    public void setCost(int[][] cost1) {
        this.cost = cost1;
    }

    /**
     * getter for the cost of the object
     * @return cost of the object
     */
    public int[][] getCost() {
        return this.cost;
    }

    /**
     * setter for the sources of the object
     * @param sources1 sources to be set
     */
    public void setSources(Source[] sources1) {
        this.sources = sources1;
    }

    /**
     * getter for the sources of the object
     * @return sources of the object
     */
    public Source[] getSources() {
        return this.sources;
    }

    /**
     * setter for the destinations of the object
     * @param destinations1 destinations to be set
     */
    public void setDestinations(Destination[] destinations1) {
        this.destinations = destinations1;
    }

    /**
     * getter for the destinations of the object
     * @return desinations of the object
     */
    public Destination[] getDestinations() {
        return this.destinations;
    }
}
