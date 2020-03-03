import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // addFirst
    // addLast
    // deleteFirst
    // deleteLast
    // contains
    // size
    // indexOf
    // printMylinkedList
    // isEmpty
    // toArray
    // reverse a linked list in place reverse
    // find the kth node from the last in one pass

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == item) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int item) {
        Node current = first;
        while (current != null) {
            if (current.value == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean containsUsingIndex(int item) {
        return indexOf(item) != -1;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        Node tmp = first.next;
        first.next = null;
        first = tmp;
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        Node prev = getPrevious(last);
        prev.next = null;
        last = prev;
        size--;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index] = current.value;
            index++;
            current = current.next;
        }
        return array;
    }

    // reverse a linked list in place reverse
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        Node prev = first;
        Node current = first.next;
        while (current != null) {
            Node tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        last = first;
        last.next = null;
        first = prev;
    }

    // find the kth node from the last in one pass
    public int getKthFromTheEnd(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node start = first;
        Node end = first;
        for (int i = 0; i < k - 1; i++) {
            end = end.next;
            if (end == null) {
                throw new IllegalArgumentException();
            }
        }
        while (end != last) {
            end = end.next;
            start = start.next;
        }
        return start.value;
    }

    /*
     * 1- Find the middle of a linked list in one pass. If the list has an even
     * number of nodes, there would be two middle nodes. (Note: Assume that you
     * don’t know the size of the list ahead of time.)
     * 
     */
    public void printMiddle() {
        // two pointers
        // a moves one step
        // b moves two steps
        // b == last means the nodes are odd
        // else means the nodes are even
        Node a = first;
        Node b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }
        if (b == last) {
            System.out.println(a.value);
        } else {
            System.out.println(a.value + ", " + a.next.value);
        }
    }

    /* Check if a linked list has a loop */
    /*
     * Hint: use two pointers (slow and fast) to traverse the list. Move the slow
     * pointer one step forward and the fast pointer two steps forward. If there’s a
     * loop, at some point, the fast pointer will meet the slow pointer and overtake
     * it. Draw this on a paper and see it for yourself. This algorithm is called :
     * Floyd’s Cycle-finding Algorithm.
     */
    public boolean hasLoop() {
        // This algorithm is called Floyd’s Cycle-finding Algorithm
        // move a one step
        // move b two steps
        // If there’s a loop, at some point,
        // the fast pointer will meet the slow pointer and overtake it.
        Node a = first;
        Node b = first;
        while (b != null && b.next != null) {
            b = b.next.next;
            a = a.next;
            if (a == b) {
                return true;
            }
        }
        return false;
    }

    public static LinkedList createWithLoop() {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        Node node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public void printMylinkedList() {
        System.out.println("Your list");
        if (isEmpty()) {
            System.out.println("Your list is empty");
        } else {
            Node current = first;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }
        System.out.println("End of list");
    }

}