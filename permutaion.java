package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class permutaion {
    static ArrayList<String> list = new ArrayList<>();
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String without space");
        String str = sc.nextLine();
        System.out.println("Possible Permutation");
        Find(str,"");
        System.out.println("All permutations");
        System.out.println(list);
        System.out.println("Number of permutations : "+count);
    }
    private static void Find(String s,String ans)
    {
        if(s.length()==0)
        {
            count++;
            list.add(ans);
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++)
        {
            String Newstr =s.substring(0, i)+s.substring(i+1);
            Find(Newstr, ans+s.charAt(i)); 
        }
    }
}
