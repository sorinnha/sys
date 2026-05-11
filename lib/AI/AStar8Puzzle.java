import java.util.*;

public class AStar8Puzzle {
    static int[][] goal = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    static class Node {
        int[][] s;
        int g, f, x, y;

        Node(int[][] s, int g, int x, int y) {
            this.s = s;
            this.g = g;
            this.x = x;
            this.y = y;

            int h = 0;

            for (int i = 0; i < 9; i++) {
                if (s[i / 3][i % 3] != 0 &&
                    s[i / 3][i % 3] != goal[i / 3][i % 3]) {
                    h++;
                }
            }

            this.f = g + h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] start = new int[3][3];
        int sx = 0, sy = 0;

        System.out.println("Enter 8 Puzzle Input:");

        for (int i = 0; i < 9; i++) {
            start[i / 3][i % 3] = sc.nextInt();

            if (start[i / 3][i % 3] == 0) {
                sx = i / 3;
                sy = i % 3;
            }
        }

        PriorityQueue<Node> pq =
                new PriorityQueue<>(Comparator.comparingInt(n -> n.f));

        Set<String> seen = new HashSet<>();

        pq.add(new Node(start, 0, sx, sy));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (!seen.add(Arrays.deepToString(curr.s))) {
                continue;
            }

            System.out.printf(
                "\ng=%d, h=%d\n%s\n",
                curr.g,
                curr.f - curr.g,
                Arrays.deepToString(curr.s).replace("], ", "]\n")
            );

            if (Arrays.deepEquals(curr.s, goal)) {
                System.out.println("Goal Reached!");
                return;
            }

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    int[][] next = Arrays.stream(curr.s)
                                         .map(int[]::clone)
                                         .toArray(int[][]::new);

                    next[curr.x][curr.y] = next[nx][ny];
                    next[nx][ny] = 0;

                    pq.add(new Node(next, curr.g + 1, nx, ny));
                }
            }
        }
    }
}