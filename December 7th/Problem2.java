import java.util.*;

public class Problem2 {

    public static class Entry {

        public String name;
        public int weight;
        public ArrayList<String> children;

    }

    public static int test(String node, HashMap<String, Entry> map) {

        Entry e = map.get(node);
        int[] weights = new int[e.children.size()];

        if (weights.length == 0) return e.weight;

        // Calculate for the children

        int sum = e.weight;
        for (int i = 0; i < weights.length; ++i) {

            weights[i] = test(e.children.get(i), map);
            sum += weights[i];

        }

        // Find the right weight

        int rightWeight = 0;
        if (weights.length > 2) {

            if (weights[0] == weights[1]) rightWeight = weights[0];
            else rightWeight = weights[2];

            // Check if there is a wrong one

            for (int i = 0; i < weights.length; ++i) {
                if (weights[i] != rightWeight) {

                    System.out.println("Wrong weight " + e.children.get(i) + " is " + map.get(e.children.get(i)).weight);
                    System.out.println("Was supposed to be " + rightWeight + " but it is " + weights[i]);

                    sum -= weights[i] - rightWeight;

                }
            }

        }

        return sum;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Build the tree

        String rootName = "gynfwly";
        HashMap<String, Entry> tree = new HashMap<String, Entry>();

        while (sc.hasNext()) {

            String s = sc.nextLine();
            String[] parts = s.split(" -> ");

            //

            String[] leftParts = parts[0].split(" ");
            String root = leftParts[0];

            String weight_s = leftParts[1].substring(1, leftParts[1].length() - 1);

            int weight = Integer.parseInt(weight_s);

            Entry e = new Entry();
            e.name = root;
            e.weight = weight;
            e.children = new ArrayList<String>();

            //

            if (parts.length > 1) {
                String[] rightParts = parts[1].split(", ");
                for (int i = 0; i < rightParts.length; ++i) {

                    e.children.add(rightParts[i]);

                }
            }

            tree.put(root, e);

        }

        // Go recursively

        test(rootName, tree);

    }

}