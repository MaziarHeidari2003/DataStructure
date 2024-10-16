public class Main {
    public static void main(String args[]){
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
        myList.addFirst(0);
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addFirst(3);
        myList.addLast(6);
        myList.addLast(5);
        myList.addLast(4);
        myList.addFirst((10));
        myList.addLast((10));
        myList.addFirst((100));
        myList.addLast((100));
        myList.removeDuplicate();
        System.out.println("The duplicated elements are gone!");
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        System.out.println("Now lets remove the head and the tail");
        myList.removeFirst();
        myList.removeLast();
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }



    }
}
