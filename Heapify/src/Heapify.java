import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class Heapify<E> extends LinkedBinaryTree<E> {
    private int size;

    @Override
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);

        // Log the current state
        System.out.println("Attaching trees to node with element: " + node.getElement());

        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }

        // Ensure the attached trees are distinct from the current tree
        if (this == t1 || this == t2) {
            throw new IllegalArgumentException("Cannot attach a tree to itself");
        }

        // Attach left tree
        if (!t1.isEmpty()) {
            node.setLeft(t1.root);
            t1.root.setParent(node);
            size += t1.size();
            t1.root = null; // make t1 an empty tree
            t1.size = 0;
        }

        // Attach right tree
        if (!t2.isEmpty()) {
            node.setRight(t2.root);
            t2.root.setParent(node);
            size += t2.size();
            t2.root = null; // make t2 an empty tree
            t2.size = 0;
        }

        // Log successful attachment
        System.out.println("Trees successfully attached to node with element: " + node.getElement());
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Add a root node
        Position<String> root = tree.addRoot("Root");

        // Add left and right children to the root
        Position<String> leftChild = tree.addLeft(root, "Left Child");
        Position<String> rightChild = tree.addRight(root, "Right Child");

        // Add children to the left child
        tree.addLeft(leftChild, "Left-Left Child");
        tree.addRight(leftChild, "Left-Right Child");

        // Add children to the right child
        tree.addLeft(rightChild, "Right-Left Child");
        tree.addRight(rightChild, "Right-Right Child");

        // Display tree information
        System.out.println("Root: " + root.getElement());
        System.out.println("Left child of root: " + leftChild.getElement());
        System.out.println("Right child of root: " + rightChild.getElement());
        System.out.println("Size of the tree: " + tree.size());
    }


}
