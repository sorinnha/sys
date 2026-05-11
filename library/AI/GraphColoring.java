public class GraphColoring {
    static int V = 4;
    static int colors = 3;

    static int graph[][] = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };

    static int color[] = new int[V];        //Stores assigned color of each vertex

    static boolean isSafe(int vertex, int c) {         //Checks whether a color can be assigned safely.

        // BRANCH & BOUND
        // Check if adjacent vertex has same color
        for (int i = 0; i < V; i++) {
            if (graph[vertex][i] == 1 && color[i] == c)     //it check the adjacent vertex of the current vertex and if it has same color then return false as adjacent vertex cannot have same colour
                return false;
        }

        return true;
    }

    static boolean solve(int vertex) {    //it tries to colur vertex one by one
        if (vertex == V)          //all vertices have been coloured successfully
            return true;

        for (int c = 1; c <= colors; c++) {
            if (isSafe(vertex, c)) {                        // it means if the colour is allowed then assign colour to vertex
                color[vertex] = c;

                if (solve(vertex + 1))       //move to next vertex
                    return true;

                // BACKTRACKING
                // Remove color if no solution found
                color[vertex] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (solve(0)) {      //means Meaning start coloring from Vertex 0
            System.out.println("Color Assignment:");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + i + " -> Color " + color[i]);
            }
        } else {
            System.out.println("No Solution");
        }
    }
}