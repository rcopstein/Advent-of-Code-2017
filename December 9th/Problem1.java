import java.util.*;

public class Problem1 {

    static int walk(char[] chars, int score, boolean ignore, boolean garbage) {

        int sum = 0;

        for (int i = 0; i < chars.length; ++i) {

                 if (ignore) { ignore = false; }
            else if (chars[i] == '!') { ignore = true; }
            else if (chars[i] == '<') { garbage = true; }
            else if (chars[i] == '>') { garbage = false; }
            else if (garbage) { continue; }
            else if (chars[i] == '{') { score += 1; }
            else if (chars[i] == '}') { sum += score--; }

        }

        return sum;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] inChars = input.toCharArray();
        int weight = walk(inChars, 0, false, false);

        System.out.println(weight);

    }

}