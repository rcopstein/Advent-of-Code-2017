public class Problem1 {

    public static void main(String[] args) {

        int input = 265149;

        int lado = 3;
        int distancia = 1;
        while (input > Math.pow(lado, 2)) { lado += 2; distancia++; }

        int limite = (int) Math.pow(lado, 2);
        while (limite > input) limite -= (lado - 1);

        int meio = limite + (lado - 1) / 2;
        int distanciaTotal = distancia + Math.abs(meio - input);

        System.out.println("Diagonal " + Math.pow(lado, 2));
        System.out.println("Inferior " + limite);
        System.out.println("Meio " + meio);
        System.out.println("Distancia " + distancia);
        System.out.println("Distancia Total " + distanciaTotal);

    }

}