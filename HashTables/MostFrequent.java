import java.util.Map;
import java.util.HashMap;

/* 
1- Find the most repeated element in an array of integers. What is the
time complexity of this method? (A variation of this exercise is finding
the most repeated word in a sentence. The algorithm is the same. Here
we use an array of numbers for simplicity.)
Input: [1, 2, 2, 3, 3, 3, 4]
Output: 3

*/
public class MostFrequent {

    // O(n)
    public static int mostFrequent(int[] arr) {
        int mostf = 0;
        // store items and their frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }
        // iterate over the hashmap to find the one with the highest frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mostf) {
                mostf = entry.getValue();
            }
        }
        return mostf;

    }

    public static void main(String args[]) {
        System.out.println(mostFrequent(new int[] { 1, 2, 2, 3, 3, 3, 4 }));
    }
}