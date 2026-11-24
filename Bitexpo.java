package BitManifilation;

import java.util.Scanner;

public class Bitexpo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        System.out.println("Enter a power varible of the number");
        int pow = sc.nextInt();
        int ans=1;
        while(pow>0)
        {
            if((pow&1)!=0)
            {
                ans=ans*n;
            }
            n=n*n;
            pow = pow>>1;
        }
        System.out.println("Power number is :"+ans);
        
    }
}
