import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;


public class MatrixMultiplier {

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Incompatible matrix dimensions for multiplication.");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                int cumule = 0;
                for (int k = 0; k < cols1; k++) {
                    cumule += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = cumule;
            }
        }

        return result;
    }

    @Test
    public void multiply_1() {
        int[][] matrix1 = {{1, 2, 3, 8}};
        int[][] matrix2 = {
            {1, 2},
            {1, 2},
            {1, 2},
            {1, 2}
        };

        int[][] expected = {
            {1*1 + 2*1 + 3*1 + 8*1, 1*2 + 2*2 + 3*2 + 8*2} // => {14, 28}
        };

        int[][] product = multiply(matrix1, matrix2);

      
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], product[i]);
        }
    }
}
