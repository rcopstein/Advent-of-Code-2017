import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        int used = 0;
        String input = "oundnydw";

        for (int i = 0; i < 128; ++i) {

            String currentInput = input + "-" + i;
            String knotHash = KnotHash.hash(currentInput);

            for (char c : knotHash.toCharArray()) {
                if (c == '0') used += 0; // 0000
                if (c == '1') used += 1; // 0001
                if (c == '2') used += 1; // 0010
                if (c == '3') used += 2; // 0011
                if (c == '4') used += 1; // 0100
                if (c == '5') used += 2; // 0101
                if (c == '6') used += 2; // 0110
                if (c == '7') used += 3; // 0111
                if (c == '8') used += 1; // 1000
                if (c == '9') used += 2; // 1001
                if (c == 'A') used += 2; // 1010
                if (c == 'B') used += 3; // 1011
                if (c == 'C') used += 2; // 1100
                if (c == 'D') used += 3; // 1101
                if (c == 'E') used += 3; // 1110
                if (c == 'F') used += 4; // 1111
            }

        }

        System.out.println(used);

    }

}