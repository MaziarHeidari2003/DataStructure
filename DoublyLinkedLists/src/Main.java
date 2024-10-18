import javax.swing.plaf.SeparatorUI;

public class Main{

    public static DoublyLinkedList createList(int from,int to){
        DoublyLinkedList myList = new DoublyLinkedList<Integer>();

        for(int i=from+1;i<to;i++){
            myList.addFirst(i);

            }
        return myList;
    }
    public static void main(String args[]){

        DoublyLinkedList myList1 = new DoublyLinkedList<Integer>();
        myList1.addFirst(1);
        myList1.addFirst(2);
        myList1.addFirst(3);
        myList1.addFirst(4);
        myList1.addFirst(5);
        myList1.addFirst(6);
        for(int i=0; i< myList1.size();i++){
            System.out.println(myList1.get(i));
        }
        System.out.println();
        System.out.println("Lets delete some of the nodes");
        System.out.println();

        myList1.removeLast();
        myList1.removeFirst();
        for(int j=0; j< myList1.size();j++){
            System.out.println(myList1.get(j));
        }

        System.out.println("Lets go for the second list!");
        DoublyLinkedList myList =createList(2,15);
        for(int k=0; k < myList.size();k++ ){
            int current =myList.get(k);
            for(int a=0; a< myList1.size();a++){
                if(current==myList1.get(a)){
                    myList.remove()
                }
            }
        }





    }
}