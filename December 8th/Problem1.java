import java.util.*;

public class Problem1 {

    static int largest = Integer.MIN_VALUE;
    static HashMap<String, Integer> values = new HashMap<>();

    static boolean test(String variable, String comparator, int value) {

        int current = 0;
        if (values.containsKey(variable)) current = values.get(variable);

        if (comparator.equals(">")) return current > value;
        if (comparator.equals("<")) return current < value;
        if (comparator.equals(">=")) return current >= value;
        if (comparator.equals("<=")) return current <= value;
        if (comparator.equals("==")) return current == value;
        if (comparator.equals("!=")) return current != value;

        return false;

    }

    static void apply(String variable, String operation, int value) {

        int current = 0;
        if (values.containsKey(variable)) current = values.get(variable);

        int modification = 0;
        if (operation.equals("inc")) modification = current + value;
        if (operation.equals("dec")) modification = current - value;

        if (modification > largest) largest = modification;
        values.put(variable, modification);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String variable = sc.next();
            String operation = sc.next();
            int value = sc.nextInt();

            sc.next(); // Jump that "if"

            String c_variable = sc.next();
            String comparator = sc.next();
            int c_value = sc.nextInt();

            if (test(c_variable, comparator, c_value)) {

                apply(variable, operation, value);

            }

        }

        System.out.println(largest);

    }

}