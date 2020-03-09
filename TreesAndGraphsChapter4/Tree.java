public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    // tree traversal
    // Breadth first level Order
    // Depth first pre order root, left, right
    // Depth first in order left, root, right
    // Depth first post order left, right, root
    public void preOrder() {
        traversepreOrder(root);
    }

    private void traversepreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traversepreOrder(root.leftChild);
        traversepreOrder(root.rightChild);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return 0;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // minimum value in a tree
    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }
        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(root.value, Math.min(left, right));
    }

    public int min() {
        return min(root);
    }

    private boolean isLeaf(Node node) {
        return root.leftChild == null && root.rightChild == null;
    }

    // a binary search tree the min is the right most leaf
    // O(log n)
    public int rightMostLeaf() {
        if (root == null) {
            throw new IllegalStateException();
        }
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }
}