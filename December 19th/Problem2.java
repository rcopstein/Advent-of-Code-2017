import java.util.*;

public class Problem2 {

    static int steps = 0;
    static int lineAux = 0;
    static char[] line = new char[26];
    static char[][] matrix = new char[250][250];

    public enum Directions { LEFT, RIGHT, UP, DOWN, STOP };

    static boolean isLetter(char c) {

        return (c - 'A') >= 0 && (c - 'A') <= 26;

    }

    static Directions GetDirection(int x, int y) {

        System.out.println("At position " + x + " / " + y);

        if (matrix[y][x-1] == '-' || isLetter(matrix[y][x-1])) return Directions.LEFT;
        if (matrix[y][x+1] == '-' || isLetter(matrix[y][x+1])) return Directions.RIGHT;
        if (matrix[y+1][x] == '|' || isLetter(matrix[y+1][x])) return Directions.DOWN;
        if (matrix[y-1][x] == '|' || isLetter(matrix[y-1][x])) return Directions.UP;

        return Directions.STOP;

    }

    static void walk(int x, int y, int dx, int dy) {

        Directions d = Directions.DOWN;

        try {

            do {

                while (matrix[y][x] != '+') {

                    if (matrix[y][x] == ' ') {
                        if (matrix[y+dy][x+dx] == ' ') {
                            System.out.println("Last Position " + x + " / " + y);
                            return;
                        }
                    }

                    if (matrix[y][x] - 'A' >= 0 && matrix[y][x] - 'A' <= 26) { line[lineAux++] = matrix[y][x]; matrix[y][x] = ' '; }
                    if (matrix[y][x] == '|' && dy != 0) matrix[y][x] = ' ';
                    if (matrix[y][x] == '-' && dx != 0) matrix[y][x] = ' ';

                    ++steps;
                    x += dx;
                    y += dy;

                }

                d = GetDirection(x, y);

                if (d == Directions.LEFT)  { dx = -1; dy = +0; }
                if (d == Directions.RIGHT) { dx = +1; dy = +0; }
                if (d == Directions.UP)    { dx = +0; dy = -1; }
                if (d == Directions.DOWN)  { dx = +0; dy = +1; }

                ++steps;
                x += dx;
                y += dy;

            }
            while (d != Directions.STOP);

        }
        catch (Exception e) {

            System.out.println("Exception");

        }

        System.out.println("Last Position " + x + " / " + y);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Fill the matrix

        int aux = 0;
        while (sc.hasNext()) {
            char[] input = sc.nextLine().toCharArray();
            for (int i = 0; i < input.length; ++i) matrix[aux][i] = input[i];
            ++aux;
        }

        // Find the entry point

        int x = 0;
        int y = 0;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[y][i] != ' ') {
                x = i;
                break;
            }
        }

        System.out.println("Starting at " + x + " / " + y);

        // Determine the direction

        int dx = 0; // Not moving sideways
        int dy = 1; // Going Down

        // Walk the path

        walk(x, y, dx, dy);

        // Print Result

        System.out.println(Arrays.toString(line));
        System.out.println(steps + " Steps");

    }

}