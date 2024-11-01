class Node {
    char value;
    Node next;

    public Node(char value){
        this.value = value;
        this.next = null;
    }
}



public class LinkedListReversePrint {

    public static void printReverse(Node node){
        if (node == null){
            return;
        }
        printReverse(node.next);
        System.out.print(node.value);

    }

    public  static  void main(String[] args){
        Node head = new Node('f');
        head.next = new Node(('l'));
        head.next.next = new Node('o');
        head.next.next.next = new Node('w');

        // well this is a nice way to make a siglylinkedlist and it is a nice way to add values to it!


        printReverse(head);
    }
}
