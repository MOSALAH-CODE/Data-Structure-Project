package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node insert(Node root, int value) {
        if (root == null){
            root = new Node(value);
            return root;
        }
        if (value < root.value)
            root.left = insert(root.left, value);
        else if (root.value < value)
            root.right = insert(root.right, value);

        return root;
    }
    public Node delete(Node root, int value)
    {
        if (root == null)
            return root;

        if (value < root.value)
            root.left = delete(root.left, value);
        else if (value > root.value)
            root.right = delete(root.right, value);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.value);
        }

        return root;
    }

    public int leafNumber(Node node){
        if (node == null) return 0;
        else if (node.left == null & node.right == null) return 1;
        else return leafNumber(node.left) + leafNumber(node.right);
    }

    public int height(Node node) {
        return node != null ? Math.max(height(node.left), height(node.right)) + 1 : -1;
    }

    public int childrenNum(Node node){
        return countNode(node) -1;
    }

    public int countNode(Node root){
        if(root == null) return 0;

        return 1 + countNode(root.left) + countNode(root.right);
    }

    public int minValue(Node node){
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return (current.value);
    }

    public int maxValue(Node node){
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return (current.value);
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node){
        if (node == null)
            return;

        System.out.print(node.value + " ");
        traversePreOrder(node.left);
        traversePreOrder(node.right);
    }

    public void traversePostOrder(Node node){
        if (node == null)
            return;

        traversePreOrder(node.left);
        traversePreOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder(Node root){
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            System.out.print(curr.value + " ");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);

        System.out.println("\n\n");
        System.out.println("Yaprak Sayisi: " + tree.leafNumber(root));
        System.out.println("Yukseklik : " + tree.height(root));
        System.out.println("Cocuk Sayisi: " + tree.childrenNum(root));
        System.out.println("Node Sayisi: " + tree.countNode(root));
        System.out.println("Min Deger: " + tree.minValue(root));
        System.out.println("Max Deger: " + tree.maxValue(root));
        System.out.print("Inorder: ");
        tree.traverseInOrder(root);
        System.out.println("\n");
        System.out.print("Preorder: ");
        tree.traversePreOrder(root);
        System.out.println("\n");
        System.out.print("Postorder: ");
        tree.traversePostOrder(root);
        System.out.println("\n");
        System.out.print("LevelOrder: ");
        tree.levelOrder(root);
        System.out.println("\n");
    }
}
