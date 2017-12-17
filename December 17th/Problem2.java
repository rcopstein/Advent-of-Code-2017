import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        int jumpBy = 367;

        int zero = 0;
        int size = 1;

        int current = 0;
        int nextToZero = 0;

        for (int i = 1; i <= 50000000; ++i) {

            current = (current + jumpBy) % size;
            if (current == 0) nextToZero = i;
            ++current;
            ++size;

        }

        System.out.println(nextToZero);

    }

}