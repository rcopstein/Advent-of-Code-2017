import java.util.*;

public class Problem2 {

    static int[] sizes;
    static int[] collision;
    static boolean[] delays;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Calculate the collision multipliers

        collision = new int[50];

        collision[1] = 1;
        collision[2] = 2;
        for (int i = 3; i < 50; ++i) collision[i] = collision[i-1] + 2;

        // Read the input

        sizes = new int[50];

        ArrayList<Integer> depths = new ArrayList<>();
        ArrayList<Integer> ranges = new ArrayList<>();

        while (sc.hasNext()) {

            String line = sc.nextLine();
            String[] parts = line.split(": ");

            depths.add(Integer.parseInt(parts[0]));
            ranges.add(Integer.parseInt(parts[1]));

        }

        int delay = 0;
        for (int i = 0; i < depths.size(); ++i) {
            if ((depths.get(i) + delay) % collision[ranges.get(i)] == 0) {
                ++delay;
                i = -1;
            }
        }
        System.out.println(delay);

    }

}