package bonus.solution;

import java.util.Vector;

public class Solution {

    private int totalCost;
    private Vector<SolutionPair> solutionPairs;

    /**
     * toString method overridden
     *
     * @return the string representation of the object
     */
    @Override
    public String toString() {
        String result = "Total Cost is : " + totalCost + "\n";
        for (SolutionPair sol : solutionPairs)
            result += sol.getSource().getName() + " -> " + sol.getDestionation().getName() + " : " + sol.getNumberOfUnits() + " " + sol.getCost() + "\n";
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return true, if this object is the same as the object argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return totalCost == solution.totalCost && solutionPairs.equals(solution.solutionPairs);
    }

    /**
     * Constructor
     *
     * @param totalCost     the total cost of the object instantiated
     * @param solutionPairs the solution pairs of the object instantiated
     */
    public Solution(int totalCost, Vector<SolutionPair> solutionPairs) {
        this.totalCost = totalCost;
        this.solutionPairs = solutionPairs;
    }

    /**
     * Default Constructor
     */
    Solution() {
        totalCost = 0;
        solutionPairs = new Vector<SolutionPair>();
    }

    /**
     * setter for the total cost of the solution
     *
     * @param totalCost1 totalCost to be set
     */
    public void setTotalCost(int totalCost1) {
        this.totalCost = totalCost1;
    }

    /**
     * getter for the total cost of the solution
     *
     * @return returns total cost of the solution
     */
    public int getTotalCost() {
        return this.totalCost;
    }

    /**
     * setter for the solution pairs of the object
     *
     * @param solutionPairs the solution pairs to be set
     */
    public void setSolutionPairs(Vector<SolutionPair> solutionPairs) {
        this.solutionPairs = solutionPairs;
    }

    /**
     * getter for the solution pairs of the object
     *
     * @return returns the solution pairs of the object
     */
    public Vector<SolutionPair> getSolutionPairs() {
        return this.solutionPairs;
    }
}
