package bonus;

import bonus.destination.Destination;
import bonus.problem.Problem;
import bonus.solution.Solution;
import bonus.source.Factory;
import bonus.source.Source;
import bonus.source.Warehouse;

public class Main {
    public static void main(String[] args) {
        Factory o1 = new Factory("o1", 300);
        Factory o2 = new Factory("o2", 400);
        Factory o3 = new Factory("o3", 500);

        Destination d1 = new Destination("d1", 250);
        Destination d2 = new Destination("d2", 350);
        Destination d3 = new Destination("d3", 400);
        Destination d4 = new Destination("d4", 200);

        Problem p = new Problem(new Source[]{o1, o2, o3}, new Destination[]{d1, d2, d3, d4}, new int[][]{{3, 1, 7, 4}, {2, 6, 5, 9}, {8, 3, 3, 2}});
        Solution s = p.solveProblem();

        System.out.println(s);
    }
}




