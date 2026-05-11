import java.util.*;
public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjacencyList = new HashMap<>();
        vertices      = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        // Add forward edge
        adjacencyList.get(from).add(to);
        // Add backward edge (undirected graph)
        adjacencyList.get(to).add(from);
    }

    public void printGraph() {
        System.out.println("Graph structure (Adjacency List):");
        for (int id : adjacencyList.keySet()) {
            System.out.println("  Vertex " + id + " -> " + adjacencyList.get(id));
        }
    }

    public void bfs(int start) {
        Set<Integer>   visited = new HashSet<>();
        Queue<Integer> queue   = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS from vertex " + start + ": ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS from vertex " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        // Mark current vertex as visited
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}