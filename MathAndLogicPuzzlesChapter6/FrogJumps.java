public class FrogJumps {
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8

        // the frog
        // jumps a fixed distance D
        // wants to get from X to Y or higher
        // minimal number of jumps to reach its target
        double res = Math.ceil((double) (Y - X) / (double) D);
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }
}