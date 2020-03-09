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

    // check if two trees are equal
    public boolean equals(Tree tree) {
        if (tree == null) {
            return false;
        }
        return equals(root, tree.root);
    }

    private boolean equals(Node f, Node s) {
        if (first == null && second == null) {
            return true;
        }
        if (f != null && s != null) {
            if (f.value == s.value) {
                return equals(f.leftChild, s.leftChild) && equals(f.rightChild, s.rightChild);
            }
        }
        return false;
    }

    // validating Binary Search tree
    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value < min || root.value > max) {
            return flase;
        }
        return isBST(root.leftChild, min, root.value - 1) && isBST(root.rightChild, root.value + 1, max);
    }

    public void swapRoot() {
        Node tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;
    }
}