import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        int count = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String input = sc.nextLine();
            String[] words = input.split(" ");

            HashSet<String> control = new HashSet<String>();

            boolean flag = true;
            for (String s : words) if (control.contains(s)) { flag = false; break; } else { control.add(s); }
            if (flag) count++;

        }

        System.out.println(count);

    }

}