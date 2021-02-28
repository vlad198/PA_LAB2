package optional;

public class Main {

    public static void main(String[] args) {
        Factory s1 = new Factory("s1", 10);
        Warehouse s2 = new Warehouse("s2", 35);
        Warehouse s3 = new Warehouse("s3", 25);

        Destionation d1 = new Destionation("d1", 20);
        Destionation d2 = new Destionation("d2", 25);
        Destionation d3 = new Destionation("d3", 25);

        Problem p = new Problem(new Source[]{s1, s2, s3}, new Destionation[]{d1, d2, d3}, new int[][]{{2, 3, 1}, {5, 4, 8}, {5, 6, 8}});
        Solution s = p.solveProblem();

        System.out.println(s);
    }


}

