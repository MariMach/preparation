public class AVLTree {

    private class AVLNode {
        private int val;
        private AVLNode right;
        private AVLNode left;
        private int height;

        public AVLNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Value=" + this.val;
        }
    }

    private AVLNode root;

    private int height(AVLNode node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private AVLNode insert(AVLNode root, int val) {
        AVLNode node = new AVLNode(val);
        if (root == null) {
            return node;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        balance(root);
        return root;
    }

    private void balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0) {
                System.out.println(root.left.val + " left rotation");
            }
            System.out.println(root.val + " right rotation");
        }
        if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0) {
                System.out.println(root.right.val + " right rotation");
            }
            System.out.println(root.val + " left rotation");
        }
    }

    private boolean isLeftHeavy(AVLNode root) {
        if (balanceFactor(root) > 1) {
            System.out.println(root.val + " is left heavy");
            return true;
        }
        return false;
    }

    private boolean isRightHeavy(AVLNode root) {
        if (balanceFactor(root) < -1) {
            System.out.println(root.val + " is right heavy");
            return true;
        }
        return false;
    }

    public void preOrder() {
        traversepreOrder(root);
    }

    private void traversepreOrder(AVLNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traversepreOrder(root.left);
        traversepreOrder(root.right);
    }

    // balanceFactor = height(L) - height(R)
    // > 1 => left heavy
    // < -1 => right heavy
    private int balanceFactor(AVLNode root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);

    }

    // leftRotate
    // rightRotate
    // leftRotate + rightRotate
    // rightRotate + leftRotate

}