import java.util.*;

public class Problem2 {

    public static String getHash(String input) {

        int[] letters = new int[26];

        char[] l = input.toCharArray();
        for (char c : l) letters[c - 'a']++;

        return Arrays.toString(letters);

    }

    public static void main(String[] args) {

        int count = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            String input = sc.nextLine();
            String[] words = input.split(" ");
            TreeSet<String> control = new TreeSet<String>();

            boolean flag = true;
            for (String s : words) 
            if (control.contains(getHash(s))) { 
                
                flag = false; 
                break; 
                
            } else { 
                
                control.add(getHash(s)); 
                
            }
            
            if (flag) ++count;
            else System.out.println(input);

        }

        System.out.println(count);

    }

}