import java.util.*;

public class Problem2 {

    public static void main(String[] args) {

        int size = 1090;

        int[] list = new int[size];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < size; ++i) list[i] = sc.nextInt();

        int aux = 0;
        int count = 0;
        while (aux >= 0 && aux < size) { 
            
            int offset = list[aux]; 
            list[aux] = list[aux] >= 3 ? list[aux] - 1 : list[aux] + 1; 
            aux += offset;
            count++; 
            
        }

        System.out.println(count);

    }

}