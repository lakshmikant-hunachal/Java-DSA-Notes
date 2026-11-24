package Binary_Tree;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class buildTree {
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
        Scanner sc = new Scanner(System.in);

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

        sc.close();
    }
}