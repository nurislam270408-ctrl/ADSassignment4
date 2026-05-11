import java.util.Random;

// Experiment class — handles execution and analysis
public class Experiment {

    // Run BFS and DFS on a given graph and measure time
    public void runTraversals(Graph g, int startVertex) {
        // Measure BFS time
        long startTime = System.nanoTime();
        g.bfs(startVertex);
        long bfsTime = System.nanoTime() - startTime;
        System.out.println("  BFS time: " + bfsTime + " ns");

        // Measure DFS time
        startTime = System.nanoTime();
        g.dfs(startVertex);
        long dfsTime = System.nanoTime() - startTime;
        System.out.println("  DFS time: " + dfsTime + " ns");
    }

    // Run experiments on different graph sizes
    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        System.out.println("==============================================");
        System.out.println("       GRAPH TRAVERSAL PERFORMANCE ANALYSIS  ");
        System.out.println("==============================================");

        for (int size : sizes) {
            System.out.println("\n--- Graph Size: " + size + " vertices ---");

            Graph g = buildRandomGraph(size);

            long startTime = System.nanoTime();
            g.bfs(0);
            long bfsTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            g.dfs(0);
            long dfsTime = System.nanoTime() - startTime;

            System.out.println("\n  BFS execution time: " + bfsTime + " ns");
            System.out.println("  DFS execution time: " + dfsTime + " ns");
            System.out.println("  Faster: " + (bfsTime < dfsTime ? "BFS" : "DFS"));
        }

        System.out.println("\n==============================================");
        System.out.println("           EXPERIMENTS DONE                   ");
        System.out.println("==============================================");
    }

    // Build a random connected graph with given number of vertices
    public Graph buildRandomGraph(int size) {
        Graph g = new Graph();
        Random rand = new Random();

        // Add all vertices
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        // Add random edges — ensure connectivity by connecting i to i+1
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }

        // Add extra random edges
        int extraEdges = size / 2;
        for (int i = 0; i < extraEdges; i++) {
            int from = rand.nextInt(size);
            int to   = rand.nextInt(size);
            if (from != to) {
                g.addEdge(from, to);
            }
        }

        return g;
    }

    public void printResults() {
        System.out.println("\nBoth BFS and DFS have time complexity O(V + E).");
        System.out.println("BFS uses a Queue (FIFO), DFS uses recursion (Stack).");
        System.out.println("BFS is better for shortest path, DFS for deep exploration.");
    }
}