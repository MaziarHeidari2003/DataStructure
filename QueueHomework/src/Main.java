public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new LinkedStack<>();
        Queue<Integer> queue = new LinkedQueue<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int x = 3;

        stack.printStack();

        boolean containsX = checkAndRestore(stack, queue, x);

        System.out.println();
        System.out.println("Does the stack contain " + x + "? " + containsX);
        System.out.println();

        stack.printStack();



    }

    public static boolean checkAndRestore(Stack<Integer> stack, Queue<Integer> queue, int x) {
        boolean found = false;

        // Transfer all elements from stack to queue and check for x
        while (!stack.isEmpty()) {
            int element = stack.pop();
            if (element == x) {
                found = true;
            }
            queue.enqueue(element);
        }

        // Transfer elements back to stack to restore original order
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        // Reverse the stack again to maintain the original order
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        return found;
    }

}
