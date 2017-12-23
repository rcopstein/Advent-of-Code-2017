import java.util.*;

public class Problem1 {

    enum Direction {

        Up,
        Down,
        Left,
        Right

    }

    static int xpos = 0;
    static int ypos = 0;
    static int size = 25;
    static int result = 0;
    static int bursts = 10000;
    static Direction currentDirection = Direction.Up;

    static Direction turn(char[][] matrix) {

        Direction d = currentDirection;
        char status = matrix[ypos][xpos];

        if (status == '#') {
            if (d == Direction.Up) return Direction.Right;
            if (d == Direction.Right) return Direction.Down;
            if (d == Direction.Down) return Direction.Left;
            if (d == Direction.Left) return Direction.Up;
        }
        else {
            if (d == Direction.Up) return Direction.Left;
            if (d == Direction.Right) return Direction.Up;
            if (d == Direction.Down) return Direction.Right;
            if (d == Direction.Left) return Direction.Down;
        }

        return Direction.Up;

    }

    static void mark(char[][] matrix) {

        if (matrix[ypos][xpos] == '#') matrix[ypos][xpos] = '.';
        else { matrix[ypos][xpos] = '#'; ++result; }

    }

    static void move() {

        if (currentDirection == Direction.Up) { --ypos; }
        if (currentDirection == Direction.Down) { ++ypos; }
        if (currentDirection == Direction.Left) { --xpos; }
        if (currentDirection == Direction.Right) { ++xpos; }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] submatrix = new char[size][size];

        for (int i = 0; i < size; ++i) {
            char[] line = sc.nextLine().toCharArray();
            for (int j = 0; j < line.length; ++j) submatrix[i][j] = line[j];
        }

        char[][] matrix = new char[1001][1001];
        int anchor = (1001/2) - (size/2);

        //
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                matrix[i][j] = '.';
            }
        }
        //

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) matrix[i + anchor][j + anchor] = submatrix[i][j];
        }

        xpos = anchor + size / 2;
        ypos = anchor + size / 2;

        for (int i = 0; i < bursts; ++i) {

            currentDirection = turn(matrix);
            mark(matrix);
            move();

        }

        System.out.println(result);

    }

}