package optional;

public class Warehouse extends Source {

    Warehouse(String name,int supply){
        this.setName(name);
        this.setSupply(supply);
        this.setType();
    }

    public void setType() {
        this.type = "Warehouse";
    }
}
