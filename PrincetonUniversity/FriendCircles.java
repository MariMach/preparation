import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {

    // DFS
    // O(n*n)
    // O(n)
    public static int findCircleNumdfs(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length;
        int circles = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(M, i, visited, n);
                circles++;
            }
        }
        return circles;
    }

    private static void dfs(int[][] M, int i, boolean[] visited, int n) {
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited, n);
            }
        }
    }

    // BFS
    // O(n*n)
    // O(n)
    public static int findCircleNumbfs(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length;
        int circles = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                visited[curr] = true;
                for (int j = 0; j < n; j++) {
                    if (M[curr][j] == 1 && !visited[j]) {
                        queue.add(j);
                    }
                }
            }
            circles++;
        }
        return circles;
    }

    public static void main(String[] args) {
        int[][] m = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        int[][] n = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        int[][] g = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int[][] k = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] l = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(findCircleNumbfs(m));
        System.out.println(findCircleNumbfs(n));
        System.out.println(findCircleNumbfs(g));
        System.out.println(findCircleNumbfs(k));
        System.out.println(findCircleNumbfs(l));
        System.out.println(findCircleNumdfs(m));
        System.out.println(findCircleNumdfs(n));
        System.out.println(findCircleNumdfs(g));
        System.out.println(findCircleNumdfs(k));
        System.out.println(findCircleNumdfs(l));

    }
}