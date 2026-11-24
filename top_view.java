package Binary_Tree;
import java.util.*;

public class top_view {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println("Top view of the binary tree:");
        printTopView(root);
    }
    public static void printTopView(Node root) {
        if (root == null) {
            return;
        }

        // Create a map to store the top view nodes
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Perform level order traversal
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> horizontalDistanceQueue = new LinkedList<>();
        queue.add(root);
        horizontalDistanceQueue.add(0);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int horizontalDistance = horizontalDistanceQueue.poll();

            // If the horizontal distance is not already present in the map, add it
            if (!topViewMap.containsKey(horizontalDistance)) {
                topViewMap.put(horizontalDistance, currentNode.data);
            }

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

        // Print the top view nodes in order of their horizontal distances
        for (int value : topViewMap.values()) {
            System.out.print(value + " ");
        }
    }
}
