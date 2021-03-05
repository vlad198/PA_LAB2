package bonus.problem;

public class PenaltyPair {
    private int maximum;
    private int index;

    public PenaltyPair(int maximum, int index) {
        this.maximum = maximum;
        this.index = index;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
