public class TreeMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
        tree.preOrder();
        AVLTree tree1 = new AVLTree();
        tree1.insert(10);
        tree1.insert(20);
        tree1.insert(30);
        tree1.preOrder();
        AVLTree tree2 = new AVLTree();
        tree2.insert(10);
        tree2.insert(30);
        tree2.insert(20);
        tree2.preOrder();
    }
}
