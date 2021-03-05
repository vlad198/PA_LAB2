package bonus.source;

public class Warehouse extends Source {

    /**
     * @param name   name of the warehouse
     * @param supply number of units the warehouse has
     */
    public Warehouse(String name, int supply) {
        super(name, "Warehouse", supply);
    }

    /**
     * setter for the type of the source
     */
    @Override
    public void setType() {
        this.type = "Warehouse";
    }
}
