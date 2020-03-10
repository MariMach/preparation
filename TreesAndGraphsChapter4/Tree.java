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
            return false;
        }
        return isBST(root.leftChild, min, root.value - 1) && isBST(root.rightChild, root.value + 1, max);
    }

    public void swapRoot() {
        Node tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;
    }

    // nodes at a given distance from the node
    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }
        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);

    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        List<Integer> list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (int value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;

        return max(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null)
            return false;

        boolean areSibling = false;
        if (root.leftChild != null && root.rightChild != null) {
            areSibling = (root.leftChild.value == first && root.rightChild.value == second)
                    || (root.rightChild.value == first && root.leftChild.value == second);
        }

        return areSibling || areSibling(root.leftChild, first, second) || areSibling(root.rightChild, first, second);
    }

    public List<Integer> getAncestors(int value) {
        List<Integer> list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value. If
        // find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.leftChild, value, list) || getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int balanceFactor = height(root.leftChild) - height(root.rightChild);

        return Math.abs(balanceFactor) <= 1 && isBalanced(root.leftChild) && isBalanced(root.rightChild);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }

    // merge two binary trees
    public Node mergeTrees(Node t1, Node t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.value += t2.val;
        t1.leftChild = mergeTrees(t1.leftChild, t2.leftChild);
        t1.rightChild = mergeTrees(t1.rightChild, t2.rightChild);
        return t1;
    }

    // inorder iterative
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
    // postorder iterative
    // preorder iterative

    // it can be don using catalan number
    // dynamic programming
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        // Base case
        dp[0] = 1;
        dp[1] = 1;
        // fill the dp table in top-down approach.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // n-i in right * i-1 in left
                dp[i] = dp[i] + (dp[i - j] * dp[j - 1]);
            }
        }
        return dp[n];
    }
}