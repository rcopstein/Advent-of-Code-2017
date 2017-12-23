import java.util.*;

public class Problem1 {

    static int[] registers = new int[8];

    static int readValue(String value) {

        char register = value.toCharArray()[0];
        if (register >= 'a' && register <= 'h') return registers[register - 'a'];
        return Integer.parseInt(value);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> program = new ArrayList<>();
        while (sc.hasNext()) program.add(sc.nextLine());

        int pc = 0;
        int result = 0;

        while (pc >= 0 && pc < program.size()) {

            String[] line = program.get(pc).split(" ");

            if (line[0].equals("set")) {

                char register = line[1].toCharArray()[0];
                registers[register - 'a'] = readValue(line[2]);
                ++pc;

            }

            if (line[0].equals("sub")) {

                char register = line[1].toCharArray()[0];
                registers[register - 'a'] -= readValue(line[2]);
                ++pc;

            }

            if (line[0].equals("mul")) {

                char register = line[1].toCharArray()[0];
                registers[register - 'a'] *= readValue(line[2]);
                ++result;
                ++pc;

            }

            if (line[0].equals("jnz")) {

                if (readValue(line[1]) != 0) pc += readValue(line[2]);
                else ++pc;

            }

        }

        System.out.println(result);

    }

}