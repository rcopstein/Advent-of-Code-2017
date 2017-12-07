import java.util.*;

public class Problem1 {

    public static void main(String[] args) {

        int size = 1090;

        int[] list = new int[size];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < size; ++i) list[i] = sc.nextInt();

        int aux = 0;
        int count = 0;
        while (aux >= 0 && aux < size) { aux += list[aux]++; count++; }

        System.out.println(count);

    }

}