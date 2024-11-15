public class Main {
    public static void main(String[] args) {
        PositionalList<Integer> list = new PositionalList<>();

        PositionalList.Position p1 = list.addFirst(1);
        PositionalList.Position p2 = list.addLast(2);
        list.addAfter(p1, 3);

        list.printList();

        list.remove(p1);
        list.printList();
    }
}
