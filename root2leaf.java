
package BST;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class root2leaf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a size of the array");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = null;

        for (int i = 0; i < n; i++) {
            root = buildTree(root, arr[i]);
        }

        System.out.println("Complete tree traversal:");
        travel(root);

        System.out.println("\nRoot-to-leaf paths:");

        ArrayList<Integer> list = new ArrayList<>();
        find(root, list);

        sc.close();
    }

    private static Node buildTree(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            root.left = buildTree(root.left, val);
        } else {
            root.right = buildTree(root.right, val);
        }

        return root;
    }

    private static void travel(Node root) {
        if (root == null) {
            return;
        }

        travel(root.left);
        System.out.print(root.data + " ");
        travel(root.right);
    }

    private static void find(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.data);

        if (root.left == null && root.right == null) {
            printpath(list);
        } else {
            find(root.left, list);
            find(root.right, list);
        }

        list.remove(list.size() - 1);
    }

    private static void printpath(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));

            if (i < list.size() - 1) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }
}
