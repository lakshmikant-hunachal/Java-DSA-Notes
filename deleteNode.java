package BST;
import java.util.*;;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
    }
}
public class deleteNode {
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
           System.out.println("Enter deleted node value (please enter node vaule in the tree only");
           int key = sc.nextInt();
           root = delete(root,key);
           System.out.println("after deleting the node");
            travel(root);
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
private static Node delete(Node root, int val) {
    if (root == null) {
        return null;
    }

    if (root.data > val) {
        root.left = delete(root.left, val);
    } 
    else if (root.data < val) {
        root.right = delete(root.right, val);
    } 
    else {
        // Case 1: No children
        if (root.left == null && root.right == null) {
            return null;
        }

        // Case 2: No left child
        if (root.left == null) {
            return root.right;
        }

        // Case 2: No right child
        if (root.right == null) {
            return root.left;
        }

        // Case 3: Two children
        Node BS = succesor(root.right);
        root.data = BS.data;
        root.right = delete(root.right, BS.data);
    }

    return root;
}
    private static Node succesor(Node root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
}
