import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("size :" + list.size());
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(90);
        list.reverse();
        int[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        list.printMylinkedList();
        System.out.println(list.indexOf(30));
        System.out.println(list.indexOf(100));
        System.out.println(list.contains(400));
        System.out.println(list.containsUsingIndex(10));
        list.deleteFirst();
        list.printMylinkedList();
        System.out.println("size :" + list.size());
        System.out.println(list.getKthFromTheEnd(2));
        System.out.println(list.getKthFromTheEnd(4));
        list.printMiddle();
        LinkedList listloop = new LinkedList();
        listloop = LinkedList.createWithLoop();
        System.out.println(listloop.hasLoop());
    }
}