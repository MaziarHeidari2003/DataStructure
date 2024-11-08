public class SinglyLinkedList<E> {
    public static class Node<E>{
        private  E element;
        private Node<E> next;

        public Node(E e,Node<E> next){
            this.element =e;
            this.next = next;
        }
        public E getElement(){
            return this.element;
        }
        public Node<E> getNext(){
            return this.next;
        }
        public void setNext(Node<E> n){this.next=n;}

    }
    private  Node<E> head = null;
    private  Node<E> tail = null;

    public SinglyLinkedList(){

    }
    private  int size = 0;
    public int size(){return this.size;}
    public boolean isEmpty(){return size == 0;}

    public E first(){
        if(isEmpty()){
            return null;
        }
        return this.head.getElement();
    }
    public E getLast(){
        if(isEmpty()){
            return null;
        }
        return this.tail.getElement();
    }

    public void addFirst(E e){
        this.head = new Node<>(e,head);
        if(isEmpty()){
            tail=head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e,null);
        if (isEmpty()){
            head=newest;
        }
        else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = this.head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return answer;
    }

    public void removeDuplicate(){
        if (isEmpty() || head.getNext() ==null){
            return;
        }
        Node<E> current = head;
        while(current != null && current.getNext() !=null){
            Node<E> runner = current;

            while(runner.getNext() !=null){
                if(current.getElement().equals(runner.getNext().getElement())){
                    runner.setNext(runner.getNext().getNext());  // Corrected line

                    size--;

                }
                else{
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }

        Node<E> temp = head;
        while(temp !=null && temp.getNext() != null){
            temp = temp.getNext();
        }
        tail=temp;
    }

    public E get(int index){
        if(index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS HONEY");
        }
        Node<E> current = this.head;
        for(int i=0; i<index; i++){
            current = current.next;
        }
        return  current.getElement();
    }


    public E removeLast() {
        if (isEmpty()) {
            return null; // List is empty, nothing to remove
        }

        if (size == 1) {
            // Special case: only one element in the list
            E answer = head.getElement();
            head = null;
            tail = null;
            size--;
            return answer;
        }

        // General case: more than one element in the list
        Node<E> current = head;
        // Traverse the list until the second-to-last element
        while (current.getNext() != tail) {
            current = current.getNext();
        }

        // At this point, 'current' is the second-to-last node
        E answer = tail.getElement();
        current.setNext(null);  // Remove the last node
        tail = current;         // Update the tail reference
        size--;
        return answer;
    }

    public Node<E> getHead(){
        return this.head;
    }

    public Node<E> getTail(){return this.tail;}

}