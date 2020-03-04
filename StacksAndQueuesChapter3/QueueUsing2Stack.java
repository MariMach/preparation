import java.util.Stack;

public class QueueUsing2Stack {

    // Q [10, 20, 30]
    // S1 [] for enqueue
    // S2 [] for dequeue

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // O(1)
    public void enqueue(int item) {
        stack1.push(item);
    }

    // O(n)
    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException();
        }
        moveStack1ToStack2();
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException();
        }
        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

}