import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashSet<String> showedUp = new HashSet<>();
        HashSet<String> candidates = new HashSet<>();

        while (sc.hasNext()) {

            String s = sc.nextLine();
            String[] parts = s.split(" -> ");

            //

            String[] leftParts = parts[0].split(" ");
            String root = leftParts[0];

            if (!showedUp.contains(root)) candidates.add(root);

            //

            if (parts.length > 1) {

                String[] rightParts = parts[1].split(", ");

                for (int i = 0; i < rightParts.length; ++i) {

                    candidates.remove(rightParts[i]);
                    showedUp.add(rightParts[i]);

                }

            }

        }

        System.out.println(candidates.iterator().next());

    }

}