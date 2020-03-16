import java.util.Set;
import java.util.HashSet;

public class Sudoku {
    public static boolean sudoku2(final char[][] grid) {
        for (int i = 0; i < 9; i++) {
            // check row
            Set<Character> set = new HashSet<>();
            for (int l = 0; l < 9; l++) {
                if (set.contains(grid[i][l])) {
                    System.out.println(grid[i][l] + ' ' + i + ' ' + l);
                    return false;
                }
                if (grid[i][l] != '.') {
                    set.add(grid[i][l]);
                }
            }
            // check column
            Set<Character> set1 = new HashSet<>();
            for (int k = 0; k < 9; k++) {
                if (set1.contains(grid[k][i])) {
                    System.out.println(grid[k][i] + ' ' + k + ' ' + i);
                    return false;
                }
                if (grid[k][i] != '.') {
                    set1.add(grid[k][i]);
                }
            }
            // check 3*3
            if (i == 0 || i == 3 || i == 6) {
                for (int r = 0; r < 9; r = r + 3) {
                    Set<Character> set2 = new HashSet<>();
                    for (int k = i; k < i + 3; k++) {
                        for (int j = r; j < r + 3; j++) {
                            if (set2.contains(grid[k][j])) {
                                System.out.println(grid[k][j] + " " + k + " " + j);
                                return false;
                            }
                            if (grid[k][j] != '.') {
                                set2.add(grid[k][j]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        final char[][] grid = new char[][] { { '.', '.', '.', '.', '.', '.', '5', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '9', '3', '.', '.', '2', '.', '4', '.', '.' }, { '.', '.', '7', '.', '.', '.', '3', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '3', '4', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '.' }, { '.', '.', '.', '.', '.', '5', '2', '.', '.' } };
        System.out.println(sudoku2(grid));
    }
}