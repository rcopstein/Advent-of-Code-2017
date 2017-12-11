import java.util.*;

public class Problem2 {

    static int walk(char[] chars, int score, boolean ignore, boolean garbage) {

        int count = 0;

        for (int i = 0; i < chars.length; ++i) {

                 if (ignore) { ignore = false; }
            else if (chars[i] == '!') { ignore = true; }
            else if (chars[i] == '>') { garbage = false; }
            else if (garbage) { ++count; }
            else if (chars[i] == '<') { garbage = true; }
            else if (chars[i] == '{') { ++score; }
            else if (chars[i] == '}') { --score; }

        }

        return count;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] inChars = input.toCharArray();
        int weight = walk(inChars, 0, false, false);

        System.out.println(weight);

    }

}