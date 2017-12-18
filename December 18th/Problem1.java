import java.util.*;

public class Problem1 {

    static long[] registers = new long[26];

    static boolean isNumber(String input) {

        int aux = 0;
        char[] chars = input.toCharArray();

        if (chars[aux] == '-') ++aux;
        if (chars[aux] >= 48 && chars[aux] <= 57) return true;
        return false;

    }

    static long getRegister(String input) {

        System.out.println("Get register for " + input);

        char r = input.toCharArray()[0];
        return registers[r - 'a'];

    }

    static long getValue(String input) {

        System.out.println("Get value for " + input);

        if (isNumber(input)) return Integer.parseInt(input);
        else return getRegister(input);

    }

    static void setValue(String register, long value) {

        char r = register.toCharArray()[0];
        registers[r - 'a'] = value;

        System.out.println("Set " + register + " to " + value);

    }

    public static void main(String[] args) {

        // 

        Scanner sc = new Scanner(System.in);

        //

        ArrayList<String> commands = new ArrayList<>();
        while (sc.hasNext()) commands.add(sc.nextLine());

        //

        long lastSounded = 0;

        //

        int aux = 0;
        while (aux >= 0 && aux < commands.size()) {

            String line = commands.get(aux);
            String[] parts = line.split(" ");

            System.out.println(line);

            String command = parts[0];
            if (command.equals("snd")) lastSounded = getRegister(parts[1]);
            if (command.equals("set")) setValue(parts[1], getValue(parts[2]));
            if (command.equals("add")) setValue(parts[1], getRegister(parts[1]) + getValue(parts[2]));
            if (command.equals("mul")) setValue(parts[1], getRegister(parts[1]) * getValue(parts[2]));
            if (command.equals("mod")) setValue(parts[1], getRegister(parts[1]) % getValue(parts[2]));
            if (command.equals("rcv")) if (getValue(parts[1]) != 0) { System.out.println(lastSounded); System.exit(0); }
            if (command.equals("jgz")) if (getValue(parts[1]) > 0) aux += getValue(parts[2]) - 1;

            ++aux;

            System.out.println();

        }

    }

}