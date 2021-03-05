package optional.source;

public abstract class Source {
    protected String type;
    private int supply;
    private String name;

    /**
     * toString method overridden
     *
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        String result = "Name : " + this.name + "\n";
        result += "Type : " + this.type + "\n";
        result += "Supply : " + this.supply + "\n";
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
        Source source = (Source) o;
        return supply == source.supply && type.equals(source.type) && name.equals(source.name);
    }


    /**
     * abstract method for the type
     */
    public abstract void setType();

    /**
     * getter for the type of the source
     *
     * @return returns the type of the source
     */
    public String getType() {
        return this.type;
    }

    /**
     * setter for the name of the source
     *
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the name of the source
     *
     * @return returns the name of the source
     */
    public String getName() {
        return this.name;
    }

    /**
     * setter for the supply of the source instantiated
     *
     * @param supply the supply to be set
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }

    /**
     * getter for the supply of the source instantiated
     *
     * @return the supply of the source
     */
    public int getSupply() {
        return this.supply;
    }

    /**
     * Constructor
     *
     * @param name   the name of the object instantiated
     * @param type   the type of the object instantiated
     * @param supply supply of the object instantiated
     */
    public Source(String name, String type, int supply) {
        this.name = name;
        this.type = type;
        this.supply = supply;
    }

    /**
     * Default constructor
     */
    public Source() {
        this.name = "DefaultSourceName";
        this.type = "FACTORY";
        this.supply = 0;
    }
}
