package compulsory;

/**
 * Destination class for the problem
 */
public class Destination {
    private String name;
    private int demand;

    /**
     * toString method overridden
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        String result = "Name : " + this.name + "\n";
        result += "Supply : " + this.demand + "\n";
        return result;
    }

    /**
     * setter for name
     * @param name the name of the destination to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for name
     * @return name of the destination
     */
    public String getName() {
        return this.name;
    }

    /**
     * setter for demand
     * @param demand demand of the destination to be set
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }

    /**
     * getter for demand
     * @return demand of the destination instantiated
     */
    public int getDemand() {
        return this.demand;
    }

    /**
     * Constructor
     * @param name name of the destination instantiated
     * @param demand demand of the destination instantiated
     */
    Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    /**
     * Default Constructor
     */
    Destination() {
        this.name = "DefaultDestinationName";
        this.demand = 0;
    }
}
