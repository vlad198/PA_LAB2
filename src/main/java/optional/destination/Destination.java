package optional.destination;

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
        result += "Demand : " + this.demand + "\n";
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o the reference object with which to compare.
     * @return true, if this object is the same as the object argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demand == that.demand && name.equals(that.name);
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
    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    /**
     * Default Constructor
     */
    public Destination() {
        this.name = "DefaultDestinationName";
        this.demand = 0;
    }
}
