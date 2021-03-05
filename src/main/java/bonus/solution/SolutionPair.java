package bonus.solution;

import bonus.destination.Destination;
import bonus.source.Source;

public class SolutionPair {
    private Source source;
    private Destination destination;
    private int numberOfUnits;
    private int cost;

    /**
     * Constructor
     *
     * @param source        source to be set
     * @param destination   destination to be set
     * @param numberOfUnits how many units we transfer from source to destination
     * @param cost          what is the cost of transferring a single unit
     */
    public SolutionPair(Source source, Destination destination, int numberOfUnits, int cost) {
        this.source = source;
        this.destination = destination;
        this.numberOfUnits = numberOfUnits;
        this.cost = cost;
    }

    /**
     * getter for source
     *
     * @return the source of the object
     */
    public Source getSource() {
        return source;
    }

    /**
     * setter for the source
     *
     * @param source the source to be set
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * getter for the destination of the object
     *
     * @return the destination of the object
     */
    public Destination getDestionation() {
        return destination;
    }

    /**
     * setter for the destination of the object
     *
     * @param destination the destination to be set
     */
    public void setDestionation(Destination destination) {
        this.destination = destination;
    }

    /**
     * getter for number of units for the given object
     *
     * @return number of units of the object
     */
    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    /**
     * setter for the number of units of the object
     *
     * @param numberOfUnits number of units to be set
     */
    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    /**
     * getter for the cost of the object
     *
     * @return the cost of the object
     */
    public int getCost() {
        return cost;
    }

    /**
     * setter for the cost of the object
     *
     * @param cost the cost to be set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
}
