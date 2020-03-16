public class StringBuilderUse {

    public static String joinWords(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String w : words) {
            sentence.append(w);
        }
        return sentence.toString();
    }

    public static void main(String[] args) {

        // append The StringBuilder append() method concatenates or attaches the passed
        // String argument with the existing declared string. It attaches it after the
        // declared string.
        StringBuilder sb = new StringBuilder("Hell");
        sb.append("World");// now original string is changed
        System.out.println(sb);// prints Hello World

        String[] words = { "aaaaaa", " bbbbbbbb", "3333333" };
        System.out.println(joinWords(words));
        System.out.println("StringBuilder length = " + sb.length()); // prints 5
        // capacity(): The capacity() method of StringBuilder class returns the current
        // capacity of the StringBuilder object. The default capacity of the Builder is
        // 16. If the number of character increases from its current capacity, it
        // increases the capacity by (old_capacity*2)+2 e.g. at current capacity 16, it
        // becomes (16*2)+2=34.
        System.out.println("StringBuilder capacity = " + sb.capacity()); // prints 20
        sb.ensureCapacity(18);
        // ensureCapacity(): The ensureCapacity() method of StringBuilder class ensures
        // that the given capacity is the minimum to the current capacity. If it is
        // greater than the current capacity, it increases the capacity by
        // (old_capacity*2)+2 e.g. at current capacity 16, it becomes (16*2)+2 which is
        // 34.
        System.out.println("StringBuilder capacity = " + sb.capacity()); // prints 20
        sb.ensureCapacity(50);
        System.out.println("StringBuilder capacity = " + sb.capacity()); // prints 50

        // insert insert(): StringBuilder insert() method inserts the passed String
        // argument at the passed String index.
        sb.insert(4, "o ");
        System.out.println(sb);// prints Hello World

        // replace(int startIndex, int endIndex, String str): StringBuilder replace()
        // method replaces the existing declared string. String replacement occurs from
        // the
        // passed startingIndex up to the endingIndex.
        sb.replace(6, 11, "Earth");
        System.out.println(sb);// prints Hello Earth!

        // delete delete(int startIndex, int endIndex): StringBuilder delete() method
        // deletes a character or sets of characters. Deletion occurs at passed
        // startingIndex up to endingIndex.
        sb.delete(0, 2);
        System.out.println(sb);

        // reverse(): The reverse() method of StringBuilder class reverses the existing
        // declared string. Invoking a reverse() method on a StringBuilder object with
        // no existing declared value throws NullPointerException.
        sb.reverse();
        System.out.println(sb);

    }

}