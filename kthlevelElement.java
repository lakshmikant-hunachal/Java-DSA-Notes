package Binary_Tree;
import java.util.*;
public class kthlevelElement {
    // find out the kth level elements in binary tree
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int k = 1; // Change this value to find elements at different levels
        System.out.println("Elements at level " + k + ":");
        printKthLevelElements(root, k);
        System.out.println(); // Print a new line after printing the kth level elements 
        // find out the kth level elements in binary tree level order traversal
        System.out.println("Elements at level " + k + " (Level Order Traversal):");
        printKthLevelElementsLevelOrder(root, k);
    }
    private static void printKthLevelElements(Node root, int k) {
        if (root == null) {
            return;
        }
        printKthLevelElementsHelper(root, k, 0);
    }
    private static void printKthLevelElementsHelper(Node node, int k, int currentLevel) {
        if (node == null) {
            return;
        }
        if (currentLevel == k) {
            System.out.print(node.data + " ");
        }
        printKthLevelElementsHelper(node.left, k, currentLevel + 1);
        printKthLevelElementsHelper(node.right, k, currentLevel + 1);
    }

    // another method to find out the kth level elements in binary tree level order traversal
    private static void printKthLevelElementsLevelOrder(Node root, int k) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            if (currentLevel == k) {
                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = queue.poll();
                    System.out.print(currentNode.data + " ");
                }
                return; // Exit after printing the kth level
            }

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            currentLevel++;
        }
    }
}
