import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;
import java.util.LinkedList;
import java.util.Queue;

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
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();

        // Add a root node
        Position<Integer> root = tree.addRoot(10);

        // Add left and right children to the root
        Position<Integer> leftChild = tree.addLeft(root, 20);
        Position<Integer> rightChild = tree.addRight(root, 30);

        // Add children to the left child
        tree.addLeft(leftChild, 40);
        tree.addRight(leftChild, 50);

        // Add children to the right child
        tree.addLeft(rightChild, 60);
        tree.addRight(rightChild, 70);

        // Print tree in heap order (level-order traversal)
        System.out.println("Heap Order of the Tree:");
        printLevelOrder(tree, tree.root());
    }

    // Helper method to print the tree in level-order traversal
    public static <E> void printLevelOrder(LinkedBinaryTree<E> tree, Position<E> root) {
        if (root == null) return;

        Queue<Position<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Position<E> current = queue.poll();
            System.out.print(current.getElement() + " ");

            if (tree.left(current) != null) {
                queue.add(tree.left(current));
            }
            if (tree.right(current) != null) {
                queue.add(tree.right(current));
            }
        }
    }


}
