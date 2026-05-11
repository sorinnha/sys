public class PrimMST {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        boolean visited[] = new boolean[5];
        visited[0] = true;
        int edges = 0;

        System.out.println("Edge \tWeight");

        while (edges < 4) {
            int min = 999, x = 0, y = 0;

            for (int i = 0; i < 5; i++) {
                if (visited[i]) {
                    for (int j = 0; j < 5; j++) {
                        if (!visited[j] && graph[i][j] != 0 && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + "\t" + min);
            visited[y] = true;
            edges++;
        }
    }
}