public class Dijkstra {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 10, 0, 30, 100},
            {10, 0, 50, 0, 0},
            {0, 50, 0, 20, 10},
            {30, 0, 20, 0, 60},
            {100, 0, 10, 60, 0}
        };

        int dist[] = {0, 999, 999, 999, 999};
        boolean visited[] = new boolean[5];

        for (int count = 0; count < 4; count++) {
            int min = 999, u = 0;

            for (int i = 0; i < 5; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            visited[u] = true;

            for (int v = 0; v < 5; v++) {
                if (graph[u][v] != 0 && !visited[v] && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest Distance:");
        for (int i = 0; i < 5; i++)
            System.out.println(i + " = " + dist[i]);
    }
}