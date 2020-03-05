import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineSweeperHackerEarth {

    /*
     * Int to char => char to int => increment => int to char char c = '0'; c =
     * (char) (1+'0'); int y = c - '0'; y++; char res = (char) (y+'0');
     * System.out.println(y); System.out.println(res);
     */

    public static void mineSweeper(char[][] board, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if there is a bomb
                if (board[i][j] == 42) {
                    // uodate the neighbours
                    for (int r = i - 1; r < i + 2; r++) {
                        for (int c = j - 1; c < j + 2; c++) {
                            // the condotion to update
                            if (0 <= r && r < n && 0 <= c && c < m && board[r][c] != '*') {
                                int initial = board[r][c] - '0';
                                initial++;
                                board[r][c] = (char) (initial + '0');
                            }
                        }
                    }

                }
            }
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = 0;
        int m = 0;
        int x = 1;

        while (true) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 || m == 0) {
                break;
            }

            char[][] board = new char[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String ligne = st.nextToken();
                for (int j = 0; j < m; j++) {
                    if (ligne.charAt(j) == '*') {
                        board[i][j] = ligne.charAt(j);
                    } else {
                        board[i][j] = '0';
                    }
                }
            }

            mineSweeper(board, n, m);

            System.out.println("Field#" + x);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }

            x++;
        }

    }
}
