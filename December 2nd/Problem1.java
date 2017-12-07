import java.util.*;

public class Problem1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int matrix[][] = new int[16][16];

        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                matrix[i][j] = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < 16; ++i)
        {
            int maior = matrix[i][0];
            int menor = matrix[i][0];

            for (int j = 0; j < 16; ++j)
            {
                int item = matrix[i][j];

                if (item > maior) maior = item;
                if (item < menor) menor = item;
            }

            sum += maior - menor;
        }

        System.out.println(sum);

    }

}