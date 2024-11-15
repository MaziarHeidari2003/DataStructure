public class PositionalList<E> {
    // Node class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public class Position {
        private Node<E> node;

        Position(Node<E> node) {
            this.node = node;
        }

        public E getElement() {
            return node.getElement();
        }

        Node<E> getNode() {
            return node;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public PositionalList() { }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position addFirst(E e) {
        Node<E> newNode = new Node<>(e, head);
        head = newNode;
        if (size == 0) tail = head;
        size++;
        return new Position(newNode);
    }

    public Position addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (size == 0) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
        return new Position(newNode);
    }

    public Position first() {
        if (isEmpty()) return null;
        return new Position(head);
    }

    public Position after(Position p) {
        Node<E> node = p.getNode();
        Node<E> nextNode = node.getNext();
        if (nextNode == null) return null;
        return new Position(nextNode);
    }

    // Adds a new element after a given position
    public Position addAfter(Position p, E e) {
        Node<E> node = p.getNode();
        Node<E> newNode = new Node<>(e, node.getNext());
        node.setNext(newNode);
        if (node == tail) tail = newNode;
        size++;
        return new Position(newNode);
    }

    public E remove(Position p) {
        Node<E> node = p.getNode();
        if (node == head) {
            head = head.getNext();
            if (head == null) tail = null;
        } else {
            Node<E> prev = head;
            while (prev.getNext() != node) {
                prev = prev.getNext();
            }
            prev.setNext(node.getNext());
            if (node == tail) tail = prev;
        }
        size--;
        return node.getElement();
    }

    // Iterates and prints the list (for testing)
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }


}
