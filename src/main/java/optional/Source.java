package optional;

import compulsory.SourceType;

import java.util.Objects;

abstract class Source {
    protected String type;
    private int supply;
    private String name;

    @Override
    public String toString() {
        String result = "Name : " + this.name + "\n";
        result += "Type : " + this.type + "\n";
        result += "Supply : " + this.supply + "\n";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && type.equals(source.type) && name.equals(source.name);
    }


    /**
     * abstract method
     * @param type
     */
    public abstract void setType();

    /**
     * @return
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param supply
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }

    /**
     * @return
     */
    public int getSupply() {
        return this.supply;
    }

    Source(String name, String type, int supply) {
        this.name = name;
        this.type = type;
        this.supply = supply;
    }

    Source() {
        this.name = "DefaultSourceName";
        this.type = "FACTORY";
        this.supply = 0;
    }
}
