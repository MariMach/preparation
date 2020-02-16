public class Main {

    public static void main(String[] args) {
        Array arr = new Array(8);
        arr.insert(1);
        arr.insert(10);
        arr.insert(30);
        arr.insert(7);
        arr.insert(9);
        arr.print();
        arr.reverse();
        arr.print();
        arr.insertAt(80, 4);
        arr.print();
        System.out.println("size :" + arr.size());
        System.out.println("max :" + arr.max());
        System.out.println("min :" + arr.min());
    }
}