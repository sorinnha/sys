import java.util.*;

public class DFS {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        System.out.println("DFS Traversal:");
        dfs(start);
    }
}