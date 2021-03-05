package bonus.source;

public class Factory extends Source {

    /**
     * Constructor
     * @param name name of the factory
     * @param supply number of units the factory has
     */
    public Factory(String name, int supply) {
        super(name, "Factory", supply);
    }

    /**
     * setter for the type of the source
     */
    @Override
    public void setType() {
        this.type = "Factory";
    }
}
