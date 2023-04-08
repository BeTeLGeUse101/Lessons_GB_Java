//На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

public class task_4 {
    final int BOARD_SIZE = 8;
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public void solve() {
        if (placeQueens(0)) {
            printQueens();
        } else {
            System.out.println("No solution found.");
        }
    }

    boolean placeQueens(int row) {
        if (row == BOARD_SIZE) {
            return true;
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                if (placeQueens(row + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < BOARD_SIZE; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    void printQueens() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        task_4 task = new task_4();
        task.solve();
    }
}