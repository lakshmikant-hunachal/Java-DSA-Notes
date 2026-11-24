package Binary_Tree;

public class minimumDistanceBW_Two {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left=new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        int n1=5;
        int n2=4;
        Node lca = findlca(root,n1,n2);
        int dis1 = finddis(lca,n1);
        int dis2 = finddis(lca,n2);
       System.out.println("Minimum distance between two nodes: " + (dis1 + dis2));
    }
    private static Node findlca(Node root,int n1,int n2)
    {
        if(root==null ||root.data==n1 || root.data==n2)
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
        return root;
    }
    private static  int finddis(Node node,int n)
    {
        if(node==null)
        {
            return -1;
        }
        if(node.data==n)
        {
            return 0;
        }
        int left = finddis(node.left, n);
        int right = finddis(node.right, n);
        if(left==-1 && right==-1)
        {
            return -1;
        }
        else if(left==-1)
        {
            return right+1;
        }
        else
        {
            return left+1;
        }
    }
}

// find out the Kth acenstor findout the node is same as the above code but do some changes
// that is find out the max of the left distance and right distance  and add 1 to the that one
// check max+1==k return that value and if we want print that value
