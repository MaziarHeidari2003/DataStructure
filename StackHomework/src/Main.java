public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();
        int[] elements = {1,2,3,4,5};
        for (int e:elements){
            stack.push(e);
        }
        System.out.println("Stack elements in push order:");
        displayStack(stack);
    }
    public static void displayStack(Stack<Integer> stack){
        Stack<Integer> tempStack = new LinkedStack<>();
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }
        while(!tempStack.isEmpty()){
            int element = tempStack.pop();
            System.out.println(element);
            stack.push(element);
        }

    }

}
