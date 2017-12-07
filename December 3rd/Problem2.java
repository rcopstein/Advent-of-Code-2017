public class Problem2 {

    static int input = 265149;

    public static void preenche(int[][] matriz, int x, int y) {

        int valor = 0;

        valor += matriz[x-1][y];
        valor += matriz[x+1][y];
        valor += matriz[x-1][y+1];
        valor += matriz[x+1][y+1];
        valor += matriz[x-1][y-1];
        valor += matriz[x+1][y-1];
        valor += matriz[x][y+1];
        valor += matriz[x][y-1];

        matriz[x][y] = valor;
        if (valor > input) { System.out.println(valor); System.exit(0); }

    }

    public static void main(String[] args) {

        int input = 265149;
        int[][] matriz = new int[999][999];

        for (int i = 0; i < 999; ++i)
            for (int j = 0; j < 999; ++j)
                matriz[i][j] = 0;
        
        int x = 499;
        int y = 499;

        matriz[x][y] = 1;
        x++;

        int ldist = 2;
        int udist = 1;
        int ddist = 2;
        int rdist = 2;

        while (true) {

            preenche(matriz, x, y);
            for (int i = 0; i < udist; ++i) { --y; preenche(matriz, x, y); }
            for (int i = 0; i < rdist; ++i) { --x; preenche(matriz, x, y); }
            for (int i = 0; i < ddist; ++i) { ++y; preenche(matriz, x, y); }
            for (int i = 0; i < rdist; ++i) { ++x; preenche(matriz, x, y); }

            ldist += 2;
            udist += 2;
            ddist += 2;
            rdist += 2;
            x++;

        }

    }

}