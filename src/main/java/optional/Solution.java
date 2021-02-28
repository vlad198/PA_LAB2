package optional;

import java.util.Vector;

public class Solution {

    private int totalCost;
    private Vector<SolutionPair> solutionPairs;

    Solution() {
        totalCost = 0;
        solutionPairs = new Vector<SolutionPair>();
    }

    @Override
    public String toString() {
        String result = "Total Cost is : " + totalCost + "\n";
        for (SolutionPair sol : solutionPairs)
            result += sol.getSource().getName() + " -> " + sol.getDestionation().getName() + " : " + sol.getSupply() + " " + sol.getCost() + "\n";
        return result;
    }

    public Solution(int totalCost, Vector<SolutionPair> solutionPairs) {
        this.totalCost = totalCost;
        this.solutionPairs = solutionPairs;
    }

    public void setTotalCost(int totalCost1) {
        this.totalCost = totalCost1;
    }

    public int getTotalCost() {
        return this.totalCost;
    }

    public void setSolutionPairs(Vector<SolutionPair> solutionPairs) {
        this.solutionPairs = solutionPairs;
    }

    public Vector<SolutionPair> getSolutionPairs() {
        return this.solutionPairs;
    }
}
