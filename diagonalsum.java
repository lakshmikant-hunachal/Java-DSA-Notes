import java.util.Scanner;
public class diagonalsum {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the square matrix: ");
        int n = sc.nextInt();
        int max[][] = new int[n][n];
        System.out.println("Enter the elements of the matrix: ");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                max[i][j] = sc.nextInt();
            }
        }
        // brute force approach
        // primary diagonal sum i==j but secondary diagonal sum i+j==n-1
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    sum+=max[i][j];
                }
                else if(i+j==n-1)
                {
                    sum+=max[i][j];
                }
            }
        }
        System.out.println("Sum of diagonals: " + sum);

        // optimal solution O(n) j=n-i-1
        int sum2=0;
        for(int i=0;i<n;i++)
        {
            sum2+=max[i][i];
            if(i!=n-i-1)
            {
                sum2+=max[i][n-i-1];
            }
        }
        System.out.println("Sum of diagonals (optimal): " + sum2);
    }
}
