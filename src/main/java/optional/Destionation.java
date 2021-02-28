package optional;

import java.util.Objects;

public class Destionation {
    private String name;
    private int demand;

    public String toString() {
        String result = "Name : " + this.name + "\n";
        result += "Supply : " + this.demand + "\n";
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destionation that = (Destionation) o;
        return demand == that.demand && name.equals(that.name);
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
     * @param demand
     */
    public void setDemand(int demand) {
        this.demand = demand;
    }

    /**
     * @return
     */
    public int getDemand() {
        return this.demand;
    }

    Destionation(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    Destionation() {
        this.name = "DefaultDestinationName";
        this.demand = 0;
    }

}
