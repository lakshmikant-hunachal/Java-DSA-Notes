package Binary_Tree;
import java.util.*;
public class bottom_view {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Bottom view of the binary tree:");
        printBottomView(root);
    }
    private static void printBottomView(Node root) {
        if (root == null) {
            return;
        }

        // Create a map to store the bottom view nodes
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();

        // Perform level order traversal
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> horizontalDistanceQueue = new LinkedList<>();
        queue.add(root);
        horizontalDistanceQueue.add(0);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int horizontalDistance = horizontalDistanceQueue.poll();

            // Update the bottom view map with the current node's value
            bottomViewMap.put(horizontalDistance, currentNode.data);

            // Add left and right children to the queue with updated horizontal distances
            if (currentNode.left != null) {
                queue.add(currentNode.left);
                horizontalDistanceQueue.add(horizontalDistance - 1);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
                horizontalDistanceQueue.add(horizontalDistance + 1);
            }
        }

        // Print the bottom view nodes in order of their horizontal distances
        for (int value : bottomViewMap.values()) {
            System.out.print(value + " ");
        }
        // what i sthe difference between top view and bottom view of a binary tree?
        // The top view of a binary tree is the set of nodes visible when the tree is viewed from the top. It includes the nodes that are at the highest level for each horizontal distance from the root. In contrast, the bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom. It includes the nodes that are at the lowest level for each horizontal distance from the root. In other words, the top view shows the first node encountered at each horizontal distance, while the bottom view shows the last node encountered at each horizontal distance.]
    }
}
