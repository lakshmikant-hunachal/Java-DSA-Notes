package Binary_Tree;
import java.util.*;
// public class LowestCommonAce {
//     // find the lowest common ancestor of two nodes in a binary tree
//     public static void main(String[] args) {
//         // Example usage
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.right.right = new Node(6);

//         int n1 = 4, n2 = 5;
//        ArrayList<Node> path1 = new ArrayList<>();
//        ArrayList<Node> path2 = new ArrayList<>();
//        getPath(root, n1, path1);
//        getPath(root, n2, path2);

//     //    check lowest common acestor
//     int i=0;
//     for(;i<path1.size() && i<path2.size();i++){
//         if(path1.get(i)!=path2.get(i)){
//             break;
//         }
//         int lca=path1.get(i-1).data;
//         System.out.println("Lowest common ancestor of "+n1+" and "+n2+" is: "+lca);

//     }
// }
//     private static boolean getPath(Node root, int target, ArrayList<Node> path) {
//         if (root == null) {
//             return false;
//         }
//         path.add(root);
//         if (root.data == target) {
//             return true;
//         }
//         if (getPath(root.left, target, path) || getPath(root.right, target, path)) {
//             return true;
//         }
//         path.remove(path.size() - 1);
//         return false;
//     }
// }
public class LowestCommonAce {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        int n1=5;
        int n2=6;
        Node lca = findlca(root,n1,n2);
        System.out.println("Lowest common acestor value : "+lca.data);
    }
    private static Node findlca(Node root,int n1,int n2)
    {
         if(root==null || root.data==n1 || root.data==n2)
         {
            return root;
         }
        Node left = findlca(root.left, n1, n2);
        Node right = findlca(root.right, n1, n2);
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        return  root;
    }
}
