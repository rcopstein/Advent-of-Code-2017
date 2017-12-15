import java.util.*;

public class Problem2 {

    static void FloodFill(int[][] matrix, int i, int j, int region) {

        if (i < 0 || i >= 128 || j < 0 || j >= 128) return;
        if (matrix[i][j] != -1) return;

        matrix[i][j] = region;

        FloodFill(matrix, i - 1, j, region);
        FloodFill(matrix, i + 1, j, region);
        FloodFill(matrix, i, j + 1, region);
        FloodFill(matrix, i, j - 1, region);

    }

    public static void main(String[] args) {

        String input = "oundnydw";
        int[][] matrix = new int[128][128];

        // Fill the matrix

        for (int ik = 0; ik < 128; ++ik) {

            int aux = 0;
            String currentInput = input + "-" + ik;
            String knotHash = KnotHash.hash(currentInput);

            for (char c : knotHash.toCharArray()) {
                
                int num = Integer.parseInt(c + "", 16);
                for (int i = 8; i > 0; i = i >> 1) {
                    
                    matrix[ik][aux] = (num & i) > 0 ? -1 : 0;
                    ++aux;

                }
            }
        }

        // Flood fill

        int region = 0;

        for (int i = 0; i < 128; ++i) {
            for (int j = 0; j < 128; ++j) {
                if (matrix[i][j] == -1) {

                    FloodFill(matrix, i, j, ++region);

                }
            }
        }

        System.out.println(region);

    }

}