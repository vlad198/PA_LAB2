package optional;

import optional.destination.Destination;
import optional.problem.Problem;
import optional.solution.Solution;
import optional.source.Factory;
import optional.source.Source;
import optional.source.Warehouse;

public class Main {

    public static void main(String[] args) {
        Factory s1 = new Factory("s1", 10);
        Warehouse s2 = new Warehouse("s2", 35);
        Warehouse s3 = new Warehouse("s3", 25);

        Destination d1 = new Destination("d1", 20);
        Destination d2 = new Destination("d2", 25);
        Destination d3 = new Destination("d3", 25);

        Problem p = new Problem(new Source[]{s1, s2, s3}, new Destination[]{d1, d2, d3}, new int[][]{{2, 3, 1}, {5, 4, 8}, {5, 6, 8}});
        Solution s = p.solveProblem();

        System.out.println(s);
    }


}

