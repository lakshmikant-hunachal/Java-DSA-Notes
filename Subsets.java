package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Subsets {
    static  ArrayList<String> list = new ArrayList<>();
    static  int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String Without Space");
        String str = sc.nextLine();
        Find(str,"",0);
        System.out.println(list);
        System.out.println("Number of subsets : "+count);
    }
    public static void Find(String s,String ans,int i)
    {
        if(i==s.length())
        {
            if(ans.length()==0)
            {
                System.out.println("NULL");
                list.add("NULL");
            }
            else{
                System.out.println(ans);
                list.add(ans);
            }
            count++;
            return;
        }
        Find(s,ans+s.charAt(i),i+1);
        Find(s, ans, i+1);
    }
}
