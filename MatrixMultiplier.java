import java.util.*;

public class MatrixMultiplier {

    public static List<List<Integer>> multiply(int[][] matrix1, int[][] matrix2) {
        List<List<Integer>> result = new ArrayList<>();

        int rows1 = matrix1.length;
        int cols2 = matrix2[0].length;

        for (int i = 0; i < rows1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols2; j++) {
                int cumule = 0;
                for (int k = 0; k < matrix2.length; k++) {
                    cumule += matrix1[i][k] * matrix2[k][j];
                }
                row.add(cumule);
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 8}};
        int[][] matrix2 = {
            {1, 2},
            {1, 2},
            {1, 2},
            {1, 2}
        };

        List<List<Integer>> product = multiply(matrix1, matrix2);
        System.out.println(product); 
    }
}
