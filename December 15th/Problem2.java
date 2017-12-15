import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        int judge = 0;

        long multA = 16807;
        long multB = 48271;

        long limit = 2147483647;

        long A = 703; // From Puzzle Input
        long B = 516;

        int count = 0;
        while (count++ < 5000000) {

            do { A = (A * multA) % limit; } while (A % 4 != 0);
            do { B = (B * multB) % limit; } while (B % 8 != 0);

            boolean flag = true;
            int mask = 1;

            while (mask < 65536) { 
                
                flag = flag && (A & mask) == (B & mask); 
                mask = mask << 1; 
                
            }
            if (flag) ++judge;

        }

        System.out.println(judge);

    }

}

// 0 2 4 8 16 32 64 128 256 512 1024 2048 4096 8192 16384 32768 65536