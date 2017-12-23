import java.util.*;

public class Problem2 {

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
    static int bursts = 10000000;
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

        if (status == '.') {
            if (d == Direction.Up) return Direction.Left;
            if (d == Direction.Right) return Direction.Up;
            if (d == Direction.Down) return Direction.Right;
            if (d == Direction.Left) return Direction.Down;
        }

        if (status == 'F') {
            if (d == Direction.Up) return Direction.Down;
            if (d == Direction.Right) return Direction.Left;
            if (d == Direction.Down) return Direction.Up;
            if (d == Direction.Left) return Direction.Right;
        }

        return currentDirection;

    }

    static void mark(char[][] matrix) {

             if (matrix[ypos][xpos] == '#') matrix[ypos][xpos] = 'F';
        else if (matrix[ypos][xpos] == '.') matrix[ypos][xpos] = 'W';
        else if (matrix[ypos][xpos] == 'W') { matrix[ypos][xpos] = '#'; ++result; }
        else if (matrix[ypos][xpos] == 'F') matrix[ypos][xpos] = '.';

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

        int bigSize = 10000;
        char[][] matrix = new char[bigSize][bigSize];
        int anchor = (bigSize/2) - (size/2);

        for (int i = 0; i < bigSize; ++i) {
            for (int j = 0; j < bigSize; ++j) {
                matrix[i][j] = '.';
            }
        }

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