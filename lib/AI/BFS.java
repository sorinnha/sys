import java.util.*;

// Graph class
class Graph {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    // Constructor
    Graph(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for(int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge for undirected graph
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    // Recursive BFS function
    void BFSRecursive(Queue<Integer> queue, boolean[] visited) {

        // Base condition
        if(queue.isEmpty()) {
            return;
        }

        // Remove node from queue
        int node = queue.poll();

        // Print node
        System.out.print(node + " ");

        // Visit all adjacent nodes
        for(int neighbor : adjList[node]) {

            if(!visited[neighbor]) {

                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }

        // Recursive call
        BFSRecursive(queue, visited);
    }

    // BFS starting function
    void BFS(int start) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        BFSRecursive(queue, visited);
    }

    // Main method
    public static void main(String args[]) {

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("BFS Traversal:");

        g.BFS(0);
    }
}