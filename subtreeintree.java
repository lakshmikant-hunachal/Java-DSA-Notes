package Binary_Tree;

public class subtreeintree {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(2);

        boolean isSubtree = isSubtree(root, subRoot);
        System.out.println("Is subtree: " + isSubtree);
    }
    private static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    private static boolean isSameTree(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.data != subRoot.data) {
            return false;
        }
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
