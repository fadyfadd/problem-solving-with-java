import java.util.*;

public class SudokuValidator {

    public static boolean isValid3x3Matrix(String[][] matrix, int a, int b) {
        Set<String> lookup = new HashSet<>();
        for (int y = a; y < a + 3; y++) {
            for (int x = b; x < b + 3; x++) {
                String c = matrix[y][x];
                if (!c.equals(".") && lookup.contains(c)) {
                    return false;
                }
                lookup.add(c);
            }
        }
        return true;
    }

    public static boolean isValid9x9MatrixRows(String[][] matrix, int a, int b) {
        for (int y = a; y < a + 9; y++) {
            Set<String> lookup = new HashSet<>();
            for (int x = b; x < b + 9; x++) {
                String c = matrix[y][x];
                if (!c.equals(".") && lookup.contains(c)) {
                    return false;
                }
                lookup.add(c);
            }
        }
        return true;
    }

    public static boolean isValid9x9MatrixColumns(String[][] matrix, int a, int b) {
        for (int x = b; x < b + 9; x++) {
            Set<String> lookup = new HashSet<>();
            for (int y = a; y < a + 9; y++) {
                String c = matrix[y][x];
                if (!c.equals(".") && lookup.contains(c)) {
                    return false;
                }
                lookup.add(c);
            }
        }
        return true;
    }

    public static boolean isValidSudoku(String[][] matrix) {
        if (!isValid9x9MatrixColumns(matrix, 0, 0)) return false;
        if (!isValid9x9MatrixRows(matrix, 0, 0)) return false;

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!isValid3x3Matrix(matrix, row, col)) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] board1 = {
            {"5","3",".",".","7",".",".",".","."},
            {"6",".",".","1","9","5",".",".","."},
            {".","9","8",".",".",".",".","6","."},
            {"8",".",".",".","6",".",".",".","3"},
            {"4",".",".","8",".","3",".",".","1"},
            {"7",".",".",".","2",".",".",".","6"},
            {".","6",".",".",".",".","2","8","."},
            {".",".",".","4","1","9",".",".","5"},
            {".",".",".",".","8",".",".","7","9"}
        };

        String[][] board2 = {
            {".",".","4",".",".",".","6","3","."},
            {".",".",".",".",".",".",".",".","."},
            {"5",".",".",".",".",".",".","9","."},
            {".",".",".","5","6",".",".",".","."},
            {"4",".","3",".",".",".",".",".","1"},
            {".",".",".","7",".",".",".",".","."},
            {".",".",".","5",".",".",".",".","."},
            {".",".",".",".",".",".",".",".","."},
            {".",".",".",".",".",".",".",".","."}
        };

        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));
    }
}
