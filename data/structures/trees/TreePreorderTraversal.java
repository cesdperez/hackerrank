package data.structures.trees;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal
 */

public class TreePreorderTraversal {

    class Node {
        int data;
        Node left;
        Node right;
    }

    void preOrder(Node root) {

        if (root == null) return;

        print(root);
        preOrder(root.left);
        preOrder(root.right);

    }

    void print(Node root) {
        System.out.print(root.data + " ");
    }


}
