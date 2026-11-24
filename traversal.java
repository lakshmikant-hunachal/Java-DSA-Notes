package Binary_Tree;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
public class traversal {
    static int idx = -1;

    public static Node buildTree(int[] arr) {
        idx++;

        if (idx >= arr.length || arr[idx] == -1) {
            return null;
        }

        Node newNode = new Node(arr[idx]);

        newNode.left = buildTree(arr);
        newNode.right = buildTree(arr);

        return newNode;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        idx = -1;
        Node root = buildTree(arr);

        System.out.println("Binary tree is built successfully");

        if (root != null) {
            System.out.println("Root node is: " + root.data);
        } else {
            System.out.println("The tree is empty");
        }
        System.out.println("Pre-order traversal:");
        preOrder(root);
        System.out.println("\nIn-order traversal:");
        inOrder(root);
        System.out.println("\nPost-order traversal:");
        postOrder(root);
        System.out.println("\nLevel-order traversal:");
        levelOrder(root);
        System.out.println("\nHeight of the tree: " + height(root));
        System.out.println("Sum of all nodes: " + sum(root));   
        System.out.println("Count of nodes: " + countNodes(root));

        sc.close();
    }
    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    private static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    private static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + sum(root.left) + sum(root.right);
    }
    private static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

