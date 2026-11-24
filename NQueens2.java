package Backtracking;


import java.util.Scanner;

public class NQueens2 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter board size:");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        Find(board, 0);

        if (count > 0) {
            System.out.println("Solution is found");
        } else {
            System.out.println("No Solution");
        }

        System.out.println("Total solutions: " + count);
        sc.close();
    }

    private static boolean Find(char[][] board, int row) {
        if (row == board.length) {
            count++;
            PrintBoard(board);
            return true;
        }

        boolean found = false;

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';

                if (Find(board, row + 1)) {
                    found = true;
                }

                // Backtracking
                board[row][col] = 'X';
            }
        }

        return found;
    }

    private static void PrintBoard(char[][] board) {
        System.out.println("-------- Board --------");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // Check the column above
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
