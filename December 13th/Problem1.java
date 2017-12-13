import java.util.*;

public class Problem1 {

    static int sum;
    static int[] sizes;
    static int[] collision;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Calculate the collision multipliers

        collision = new int[50];

        collision[1] = 1;
        collision[2] = 2;
        for (int i = 3; i < 50; ++i) collision[i] = collision[i-1] + 2;

        // Read the input

        sizes = new int[50];

        while (sc.hasNext()) {

            String line = sc.nextLine();
            String[] parts = line.split(": ");

            int depth = Integer.parseInt(parts[0]);
            int range = Integer.parseInt(parts[1]);

            if (depth % collision[range] == 0) sum += depth * range;

        }

        System.out.println(sum);

    }

}