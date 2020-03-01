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