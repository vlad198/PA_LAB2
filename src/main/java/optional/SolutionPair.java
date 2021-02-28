package optional;

public class SolutionPair {
    private Source source;
    private Destionation destionation;
    private int supply;
    private int cost;

    public SolutionPair(Source source, Destionation destionation, int supply, int cost) {
        this.source = source;
        this.destionation = destionation;
        this.supply = supply;
        this.cost = cost;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destionation getDestionation() {
        return destionation;
    }

    public void setDestionation(Destionation destionation) {
        this.destionation = destionation;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
