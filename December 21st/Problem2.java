import java.util.*;

public class Problem2 {

    static String[] inputs;
    static String[] outputs;

    static int iterations = 18;
    static int input_count = 108;

    static void readInput() {

        int aux = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String[] parts = sc.nextLine().split(" => ");
            outputs[aux] = parts[1];
            inputs[aux] = parts[0];
            ++aux;

            System.out.println("Read input: " + inputs[aux-1]);
            System.out.println("Read output: " + outputs[aux-1]);
            System.out.println();

        }

    }

    static char[][] initialMatrix() {

        char[][] matrix = new char[3][3];

        matrix[0][0] = '.';
        matrix[0][1] = '#';
        matrix[0][2] = '.';

        matrix[1][0] = '.';
        matrix[1][1] = '.';
        matrix[1][2] = '#';

        matrix[2][0] = '#';
        matrix[2][1] = '#';
        matrix[2][2] = '#';

        return matrix;

    }

    static char[][] mirror(char[][] matrix) {

        char[][] aux = new char[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {

                aux[i][matrix.length - 1 - j] = matrix[i][j];

            }
        }

        return aux;

    }

    static char[][] rotate(char[][] mat) {

        int N = mat.length;

        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++)
        {
            // Consider elements in group of 4 in 
            // current square
            for (int y = x; y < N-x-1; y++)
            {
                // store current cell in temp variable
                char temp = mat[x][y];
      
                // move values from right to top
                mat[x][y] = mat[y][N-1-x];
      
                // move values from bottom to right
                mat[y][N-1-x] = mat[N-1-x][N-1-y];
      
                // move values from left to bottom
                mat[N-1-x][N-1-y] = mat[N-1-y][x];
      
                // assign temp to left
                mat[N-1-y][x] = temp;
            }
        }

        return mat;
    }

    static String findPattern(char[][] matrix) {

        for (int i = 0; i < inputs.length; ++i) {

            String input = inputs[i];
            String[] input_parts = input.split("/");
            if (input_parts.length != matrix.length) continue;

            for (int mirror = 0; mirror < 2; ++mirror) {
                for (int rotate = 0; rotate < 4; ++rotate) {

                    boolean flag = true;
                    for (int j = 0; j < input_parts.length && flag; ++j) {

                        char[] line = input_parts[j].toCharArray();
                        for (int k = 0; k < line.length; ++k) if (line[k] != matrix[j][k]) flag = false;

                    }

                    if (flag) { System.out.println("Matched pattern " + inputs[i]); return outputs[i]; }
                    matrix = rotate(matrix);

                }

                matrix = mirror(matrix);
            }

        }

        System.out.println("Didn't match any pattern!");
        System.exit(0);
        return null;

    }

    static char[][] transform(String input) {

        String[] lines = input.split("/");
        char[][] matrix = new char[lines.length][lines.length];

        for (int i = 0; i < lines.length; ++i) {

            char[] line = lines[i].toCharArray();

            for (int j = 0; j < line.length; ++j) {

                matrix[i][j] = line[j];

            }
        }

        return matrix;

    }

    static char[][] iterate(char[][] matrix) {

        int divisor = matrix.length % 2 == 0 ? 2 : 3;
        int divisions = matrix.length / divisor;

        char[][] m_matrix = new char[matrix.length + divisions][matrix.length + divisions];

        for (int i = 0; i < matrix.length; i += divisor) {
            for (int j = 0; j < matrix.length; j += divisor) {

                char[][] sub_matrix = new char[divisor][divisor];

                for (int k = i; k < i + divisor; ++k)
                    for (int l = j; l < j + divisor; ++l)
                        sub_matrix[k - i][l - j] = matrix[k][l];

                String pattern = findPattern(sub_matrix);
                sub_matrix = transform(pattern);

                int istart = i + (i / divisor);
                int jstart = j + (j / divisor);

                for (int k = istart; k < istart + divisor + 1; ++k)
                    for (int l = jstart; l < jstart + divisor + 1; ++l)
                        m_matrix[k][l] = sub_matrix[k - istart][l - jstart];

            }
        }

        return m_matrix;

    }

    static int count(char[][] matrix) {

        int sum = 0;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[i][j] == '#') {
                    ++sum;
                }
            }
        }

        return sum;

    }

    static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        outputs = new String[input_count];
        inputs = new String[input_count];
        readInput();
        
        char[][] matrix = initialMatrix();

        printMatrix(matrix);
        System.out.println();
        printMatrix(matrix = rotate(matrix));
        System.out.println();
        printMatrix(matrix = rotate(matrix));
        System.out.println();
        printMatrix(matrix = rotate(matrix));
        System.out.println();
        printMatrix(matrix = rotate(matrix));
        System.out.println();

        for (int i = 0; i < iterations; ++i) {

            matrix = iterate(matrix);
            printMatrix(matrix);

            System.out.println();

        }

        System.out.println(count(matrix));

    }

}