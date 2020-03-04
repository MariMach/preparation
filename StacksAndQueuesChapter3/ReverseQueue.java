import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverse(Queue<Integer> queue) {
        // add
        // remove
        // isEmpty
        // initial queue [10, 20, 30, 40, 50, 60]
        // use a stack 10, 20, 30 , 40 , 50 , 60
        // copy it to the queu 60, 50, 40, 30, 20, 10
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    /*
     * Given an integer K and a queue of integers, write code to reverse the order
     * of the first K elements of the queue. Input: Q = [10, 20, 30, 40, 50], K = 3
     * Output: Q = [30, 20, 10, 40, 50]
     */
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        reverse(queue);
        System.out.println(queue);
        int front = queue.remove();
        System.out.println(front);
    }
}