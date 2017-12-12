import java.util.*;

public class Problem2 {

    static HashMap<Integer, Integer> groups = new HashMap<>();

    static int Walk(int index, int group, boolean[][] matrix, HashSet<Integer> passed) {

        if (passed.contains(index)) return 0;
        passed.add(index);

        groups.put(index, group);

        int aux = 1;
        for (int i = 0; i < matrix[index].length; ++i)
            if (matrix[index][i])
                aux += Walk(i, group, matrix, passed);

        return aux;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean[][] matrix = new boolean[2000][2000];

        while (sc.hasNext()) {

            String line = sc.nextLine();
            String[] parts = line.split(" ");

            int from = Integer.parseInt(parts[0]);

            for (int i = 2; i < parts.length; ++i) {

                if (i < parts.length - 1) parts[i] = parts[i].substring(0, parts[i].length() - 1);
                int to = Integer.parseInt(parts[i]);
                matrix[from][to] = true;

            }

        }

        int g = 0;
        for (int i = 0; i < 2000; ++i)
        {
            if (groups.containsKey(i)) continue;

            HashSet<Integer> passed = new HashSet<Integer>();
            int result = Walk(i, g++, matrix, passed);
        }

        System.out.println(g);

    }

}