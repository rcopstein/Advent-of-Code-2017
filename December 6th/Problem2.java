import java.util.*;

public class Problem2 {

    //static int[] input = new int[] { 0, 2, 7, 0 };
    static int[] input = new int[] { 4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5 };

    static int findLargest() {

        int largest = 0;
        for (int i = 0; i < input.length; ++i) if (input[i] > input[largest]) largest = i;
        return largest;

    }

    static int clear(int location) {

        int aux = input[location];
        input[location] = 0;
        return aux;

    }

    static void distribute(int startAt, int amount) {

        while (amount > 0) {

            ++input[startAt];
            --amount;

            startAt = (startAt + 1) % input.length;

        }

    }

    static String getHash() {

        return Arrays.toString(input);

    }

    public static void main(String[] args) {

        int count = 0;
        HashMap<String, Integer> configToIteration = new HashMap<>();

        while (true) {

            ++count;

            int largest = findLargest();
            int amount = clear(largest);
            int startAt = (largest + 1) % input.length;
            distribute(startAt, amount);

            String hash = getHash();
            if (configToIteration.containsKey(hash)) { 
                
                System.out.println(count - configToIteration.get(hash)); 
                return; 
                
            }
            configToIteration.put(hash, count);

        }

    }

}