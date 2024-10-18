public class DoublyLinkedList<E> {
    private  static  class Node<E>{
        private  E element;
        private Node<E> prev;
        private  Node<E> next;
        public Node(E e,Node<E> p,Node<E> n){
            this.element = e;
            this.setPrev(p);
            this.next=n;
        }
        public E getElement(){return this.element;}
        public Node<E> getPrev(){return this.prev;}
        public Node<E> getNext(){return this.next;}
        public void setNext(Node<E> n){this.next=n;}
        public void setPrev(Node<E> p){this.prev=p;}
    }
    private  Node<E> header;
    private Node<E> trailer;
    private  int size=0;

    public  DoublyLinkedList(){
        this.header= new Node<>(null,null,null);
        this.trailer = new Node<>(null,header,null);
        header.setNext(this.trailer);

    }
    public int size(){return this.size;}

    public boolean isEmpty(){
        return this.size==0;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }
        return this.header.getNext().getElement();
    }
     public E last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
     }

    public void addBetween(E e,Node<E> predecessor,Node<E> successor){
        Node<E> newest = new Node<E>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        this.size++;
    }

    public E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        this.size--;
        return node.getElement();

    }

    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public E removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }
    public E removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

    public E get(int index){
        if(index < 0 || index >= size ){
            throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS HONEY");
        }
        Node<E> current = this.header.getNext();
        for(int i=0;i<index;i++){
            current=current.getNext();
        }
        return  current.getElement();


    }

}
