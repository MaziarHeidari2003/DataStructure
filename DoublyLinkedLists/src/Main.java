import javax.swing.plaf.SeparatorUI;
import java.net.Inet4Address;

public class Main{

    public static DoublyLinkedList<Integer> createList(int from,int to,DoublyLinkedList<Integer> firstList) {
        DoublyLinkedList secondList = new DoublyLinkedList<Integer>();
        for (int i = from + 1; i < to; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < firstList.size(); j++) {
                if (i == firstList.get(j)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                secondList.addFirst(i);
            }
        }
        return secondList;

    }


    public static void main(String args[]){

        DoublyLinkedList firstList = new DoublyLinkedList<Integer>();
        firstList.addFirst(1);
        firstList.addFirst(2);
        firstList.addFirst(3);
        firstList.addFirst(4);
        firstList.addFirst(5);
        firstList.addFirst(6);
        for(int i=0; i< firstList.size();i++){
            System.out.println(firstList.get(i));
        }
        System.out.println("Lets delete some of the nodes");

        firstList.removeLast();
        firstList.removeFirst();
        for(int j=0; j< firstList.size();j++){
            System.out.println(firstList.get(j));
        }

        System.out.println("Creating second list excluding elements from the first list...");
        DoublyLinkedList<Integer> secondList = createList(2, 15, firstList);

        System.out.println("Second List:");
        for (int k = 0; k < secondList.size(); k++) {
            System.out.println(secondList.get(k));
        }




    }
}