package optional;

public class Factory extends Source {

    Factory(String name,int supply){
        this.setName(name);
        this.setSupply(supply);
        this.setType();
    }

    public void setType() {
        this.type = "Factory";
    }

}
