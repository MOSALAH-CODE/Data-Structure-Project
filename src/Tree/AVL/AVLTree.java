package Tree.AVL;

// Java program for insertion in AVL Tree
class Node {
    int value, height;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.height = 1;
        this.left = this.right = null;
    }
}

class AVLTree {

    Node root;

    // A utility function to get the height of the tree
    int height(Node node) {
        return node != null ? node.height : 0;
    }

    void updateHeight(Node node){
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    Node rightRotate(Node node) {
        Node leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    Node leftRotate(Node node) {
        Node rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    int getBalance(Node node) {
        return node != null ? height(node.left) - height(node.right) : 0;
    }

    Node insert(Node node, int value) {
        if (node == null)
            return (new Node(value));

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else // Duplicate keys not allowed
            return node;

        updateHeight(node);

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            System.out.print(node.value + " ");
            preOrder(node.right);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 9);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println("\nInorder traversal" +
                " of constructed tree is : ");
        tree.inOrder(tree.root);
    }
}
// This code has been contributed by Mayank Jaiswal