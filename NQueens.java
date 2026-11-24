package Backtracking;

import java.util.Scanner;
public class NQueens {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter board size");
        int n = sc.nextInt();
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='X';
            }
        }
        Find(board,0);
        System.out.println("Number of solution : "+count);
    }
    private static void Find(char[][] board,int row)
    {
        if(row==board.length)
        {
            count++;
            PrintBoard(board);
            return ;
        }
            for(int i=0;i<board.length;i++)
            {
                if(isSafe(board,row,i))
                {
                    board[row][i]='Q';
                    Find(board, row+1);
                    // backtracking
                    board[row][i]='X';
                }

            }
    }
    private static void PrintBoard(char[][] board)
    {
        System.out.println("--------------Board-----------");
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static boolean isSafe(char[][] board,int row,int col)
    {
        // up column column is name but row reduce
        for(int i=row-1;i>=0;i--)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }
        // check up left side
        for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        // check up right side
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        return true;
    }
}
