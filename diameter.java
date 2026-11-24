
package Binary_Tree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class diameter {

    // Approach 1: O(n^2)
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int rootDiameter =
                height(root.left) + height(root.right) + 1;

        return Math.max(rootDiameter,
                Math.max(leftDiameter, rightDiameter));
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left),
                        height(root.right)) + 1;
    }

    // Store both diameter and height
    static class Info {
        int diameter;
        int height;

        Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // Approach 2: O(n)
    public static Info diameterOptimized(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameterOptimized(root.left);
        Info rightInfo = diameterOptimized(root.right);

        int height =
                Math.max(leftInfo.height, rightInfo.height) + 1;

        int diameter = Math.max(
                leftInfo.height + rightInfo.height + 1,
                Math.max(leftInfo.diameter, rightInfo.diameter)
        );

        return new Info(diameter, height);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Diameter (O(n^2)): " + diameter(root));
        System.out.println("Height: " + height(root));

        Info result = diameterOptimized(root);
        System.out.println("Diameter (O(n)): " + result.diameter);
        System.out.println("Optimized height: " + result.height);
    }
}