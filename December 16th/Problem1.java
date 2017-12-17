import java.util.*;

public class Problem1 {

    static char[] rotate(char[] source, int amount) {

        char[] result = new char[source.length];
        for (int i = 0; i < result.length; ++i) {

            int where = i - amount;
            if (where < 0) where += source.length;
            
            result[i] = source[where];

        }
        return result;

    }

    static char[] swapChar(char[] source, char from, char to) {

        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < source.length; ++i) {
            if (source[i] == from) fromIndex = i;
            if (source[i] == to) toIndex = i;
        }

        return swapIndex(source, fromIndex, toIndex);

    }

    static char[] swapIndex(char[] source, int from, int to) {

        char aux = source[from];
        source[from] = source[to];
        source[to] = aux;

        return source;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int size = 16;
        char[] line = new char[size];

        for (int i = 0; i < size; ++i) line[i] = (char) ('a' + i);

        String[] commands = input.split(",");
        for (int i = 0; i < commands.length; ++i) {

            char command = commands[i].toCharArray()[0];
            String arguments = commands[i].substring(1);

            if (command == 's') {

                int amount = Integer.parseInt(arguments);
                line = rotate(line, amount);

            }

            if (command == 'p') {

                String[] chars = arguments.split("/");
                char from = chars[0].toCharArray()[0];
                char to = chars[1].toCharArray()[0];

                line = swapChar(line, from, to);

            }

            if (command == 'x') {

                String[] indexes = arguments.split("/");
                int from = Integer.parseInt(indexes[0]);
                int to = Integer.parseInt(indexes[1]);

                line = swapIndex(line, from, to);

            }

        }

        System.out.println(Arrays.toString(line));

    }

}