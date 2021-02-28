package compulsory;

public class Source {
    private String name;
    private SourceType type;
    private int supply;

    /**
     * toString method overridden
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        String result = "Name : " + this.name + "\n";
        result += "Type : " + (type == SourceType.FACTORY ? "Factory" : "Warehouse") + "\n";
        result += "Supply : " + this.supply + "\n";
        return result;
    }


    /**
     * setter for the object type : FACTORY/WAREHOUSE
     * @param type the type to be set
     */
    public void setType(SourceType type) {
        this.type = type;
    }

    /**
     * getter for the type
     * @return the type of the object
     */
    public SourceType getType() {
        return this.type;
    }

    /**
     * setter for the name of the object
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the name
     * @return the name of the object
     */
    public String getName() {
        return this.name;
    }

    /**
     * setter for the supply
     * @param supply the supply to be set
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }

    /**
     * getter for the supply
     * @return the supply of the object
     */
    public int getSupply() {
        return this.supply;
    }

    /**
     * Constructor
     * @param name name of the source
     * @param type type of the source
     * @param supply supply of the source
     */
    Source(String name, SourceType type, int supply) {
        this.name = name;
        this.type = type;
        this.supply = supply;
    }

    /**
     * Default constructor
     */
    Source() {
        this.name = "DefaultSourceName";
        this.type = SourceType.FACTORY;
        this.supply = 0;
    }
}
