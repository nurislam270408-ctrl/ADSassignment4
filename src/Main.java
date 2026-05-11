// Main class — runs the entire graph traversal program
public class Main {

    public static void main(String[] args) {

        Experiment experiment = new Experiment();

        // ── SMALL GRAPH (10 vertices) ──────────────────
        System.out.println("=== Small Graph (10 vertices) ===");

        Graph small = new Graph();
        for (int i = 0; i < 10; i++) small.addVertex(new Vertex(i));

        small.addEdge(0, 1); small.addEdge(0, 2);
        small.addEdge(1, 3); small.addEdge(1, 4);
        small.addEdge(2, 5); small.addEdge(2, 6);
        small.addEdge(3, 7); small.addEdge(4, 8);
        small.addEdge(5, 9);

        small.printGraph();
        System.out.println();
        experiment.runTraversals(small, 0);

        // ── MEDIUM GRAPH (30 vertices) ─────────────────
        System.out.println("\n=== Medium Graph (30 vertices) ===");
        Graph medium = experiment.buildRandomGraph(30);
        experiment.runTraversals(medium, 0);

        // ── LARGE GRAPH (100 vertices) ─────────────────
        System.out.println("\n=== Large Graph (100 vertices) ===");
        Graph large = experiment.buildRandomGraph(100);
        experiment.runTraversals(large, 0);

        // ── FULL EXPERIMENT ────────────────────────────
        System.out.println();
        experiment.runMultipleTests();
        experiment.printResults();
    }
}