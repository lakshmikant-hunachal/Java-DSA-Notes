package BST;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
    }
}
public class build_search {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter a size of the array ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter a elements of the array duplicates elements are not possible");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Node root=null;
           for(int i=0;i<n;i++)
           {
            root=buildTree(root,arr[i]);
           }
           System.out.println("Tree traversal (inorder) ");
           System.out.println();
           travel(root);
           System.out.println();
           System.out.println("Enter a searching key in binary search tree");
           int key = sc.nextInt();
           if(search(root,key))
           {
              System.out.println("Key is found in  BST");
           }
           else{
            System.out.println("Key is not found in BST");
           }
        }

    private static Node buildTree(Node root,int val)
    {
        if(root==null)
        {
            root=new Node(val);
            return  root;
        }
        if(root.data>val)
        {
            root.left = buildTree(root.left, val);
        }
        else{
            root.right = buildTree(root.right, val);
        }
        return  root;
    }
    private  static  void travel(Node root)
    {
        if(root==null)
        {
            return ;
        }
        travel(root.left);
        System.out.print(root.data+" ");
        travel(root.right);
    }
    private static  boolean search(Node root,int key)
    {
        if(root==null)
        {
            return false;
        }
        else if(root.data==key)
        {
            return  true;
        }
        else if(root.data>key)
        {
            return search(root.left, key);
        }
        else
        {
            return search(root.right, key);
        }
    }
}
