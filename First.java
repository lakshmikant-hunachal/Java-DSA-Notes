package Backtracking;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        System.out.println("Enter size of the array");
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int nums[] = new int[n];
        Fill(nums,0 ,1);
        System.out.println("After backtracking array values");
        print(nums);

    }
    private static void Fill(int arr[],int idx,int val)
    {
        if(idx==arr.length)
        {
            System.out.println("Array values Before backtracking ");
            print(arr);
            return;
        }
        arr[idx]=val;
        Fill(arr, idx+1, val+1);
        arr[idx]=arr[idx]-2;
    }
    private static void print(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
