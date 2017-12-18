import java.util.*;
import java.util.concurrent.*;

public class Problem2 {

    static int program = 0;
    static long[][] registers = new long[2][26];

    static boolean isNumber(String input) {

        int aux = 0;
        char[] chars = input.toCharArray();

        if (chars[aux] == '-') ++aux;
        if (chars[aux] >= 48 && chars[aux] <= 57) return true;
        return false;

    }

    static long getRegister(String input) {

        char r = input.toCharArray()[0];
        return registers[program][r - 'a'];

    }

    static long getValue(String input) {

        if (isNumber(input)) return Integer.parseInt(input);
        else return getRegister(input);

    }

    static void setValue(String register, long value) {

        char r = register.toCharArray()[0];
        registers[program][r - 'a'] = value;

    }

    public static void main(String[] args) {

        // 

        Scanner sc = new Scanner(System.in);

        //

        ArrayList<String> commands = new ArrayList<>();
        while (sc.hasNext()) commands.add(sc.nextLine());

        //

        ArrayBlockingQueue<Long> program0Queue = new ArrayBlockingQueue(1000);
        ArrayBlockingQueue<Long> program1Queue = new ArrayBlockingQueue(1000);
        registers[1]['p' - 'a'] = 1;

        //

        int result = 0;
        int[] aux = new int[2];
        boolean[] waiting = new boolean[2];

        while (!(waiting[0] && waiting[1])) {

            if (aux[program] < 0 || aux[program] >= commands.size()) { 
                
                System.out.println("Program " + program + " terminated");

                waiting[program] = true; 
                program = (program + 1) % 2; 
                continue; 
            
            }

            String line = commands.get(aux[program]);
            String[] parts = line.split(" ");

            String command = parts[0];
            if (command.equals("set")) setValue(parts[1], getValue(parts[2]));
            if (command.equals("add")) setValue(parts[1], getRegister(parts[1]) + getValue(parts[2]));
            if (command.equals("mul")) setValue(parts[1], getRegister(parts[1]) * getValue(parts[2]));
            if (command.equals("mod")) setValue(parts[1], getRegister(parts[1]) % getValue(parts[2]));
            if (command.equals("jgz")) if (getValue(parts[1]) > 0) aux[program] += getValue(parts[2]) - 1;

            if (command.equals("snd")) {
                if (program == 0) {
                    
                    program1Queue.offer(getValue(parts[1]));
                    waiting[1] = false;
                    
                }
                else { 
                    
                    program0Queue.offer(getValue(parts[1]));
                    waiting[0] = false;
                    ++result;
                    
                }
            }

            if (command.equals("rcv")) {
                if (program == 0) {
                    if (program0Queue.isEmpty()) { 
                        
                        aux[program] = aux[program] - 1; 
                        waiting[0] = true; 

                    }
                    else { 
                        
                        setValue(parts[1], program0Queue.poll()); 
                        waiting[0] = false; 
                        
                    }
                }
                else {
                    if (program1Queue.isEmpty()) { 
                        
                        aux[program] = aux[program] - 1;
                        waiting[1] = true;
                        
                    }
                    else { 
                        
                        setValue(parts[1], program1Queue.poll());
                        waiting[1] = false;
                        
                    }
                }
            }

            ++aux[program];
            if (waiting[program]) program = (program + 1) % 2;

        }

        System.out.println(result);

    }

}