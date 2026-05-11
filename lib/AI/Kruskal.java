public class Kruskal {
    static int parent[] = {0, 1, 2, 3};

    static int find(int x) {
        while (parent[x] != x)
            x = parent[x];
        return x;
    }
    
    public static void main(String[] args) {
        int cost[][] = {
            {999, 10, 6, 5},
            {10, 999, 999, 15},
            {6, 999, 999, 4},
            {5, 15, 4, 999}
        };

        int edges = 0, minCost = 0;

        while (edges < 3) {
            int min = 999, a = 0, b = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (find(i) != find(j) && cost[i][j] < min) {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            parent[find(a)] = find(b);
            System.out.println(a + " - " + b + " = " + min);
            minCost += min;
            edges++;
        }

        System.out.println("Minimum Cost = " + minCost);
    }
}