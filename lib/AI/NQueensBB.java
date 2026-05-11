public class NQueensBB {
    static int N = 4;
    static int board[][] = new int[N][N];

    static boolean rowCheck[] = new boolean[N];                               // these threes are are use to check whether the queen is present in row, upper diaggonal(/),lower diagonal(\)
    static boolean upperDiag[] = new boolean[2 * N - 1];
    static boolean lowerDiag[] = new boolean[2 * N - 1];

    static boolean solve(int col) {                      //it tries to fill the queen column by column
        if (col >= N)                                 // if all the columns are filled then we have found a solution
            return true;

        for (int i = 0; i < N; i++) {

            // BRANCH & BOUND
            // Checking if this position is safe before placing queen
            if (!rowCheck[i] && !upperDiag[i + col] && !lowerDiag[i - col + N - 1]) {        // means place queen only if the row is empty and upper and lower diagonal is also empty

                board[i][col] = 1;              //it places the queen in the current column 
                rowCheck[i] = true;                             //mark the row and upper and lower diagonal as occupied
                upperDiag[i + col] = true;
                lowerDiag[i - col + N - 1] = true;

                if (solve(col + 1))                      //move to next column
                    return true;

                // BACKTRACKING
                // Remove queen if current path gives no solution
                board[i][col] = 0;              // remove the queen from the current column
                rowCheck[i] = false;                                                 //mark the row and upper and lower diagonal as unoccupied
                upperDiag[i + col] = false;
                lowerDiag[i - col + N - 1] = false;
            }
        }
        return false;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (solve(0))                      //start from column zero
            printBoard();
        else
            System.out.println("No Solution");
    }
}