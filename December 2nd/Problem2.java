import java.util.*;

public class Problem2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int matrix[][] = new int[16][16];

        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                matrix[i][j] = sc.nextInt();

        int sum = 0;

        for (int i = 0; i < 16; ++i)
        {
            for (int j = 0; j < 16; ++j)
            {
                int item = matrix[i][j];

                for (int k = 0; k < 16; ++k)
                {
                    int item2 = matrix[i][k];

                    if (item % item2 == 0 && j != k) {

                        sum += item / item2;

                    }
                }
            }
        }

        System.out.println(sum);

    }

}