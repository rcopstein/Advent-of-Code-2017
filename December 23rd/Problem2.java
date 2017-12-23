/*
 - b tem um valor inicial e c tem um valor final = b - 17000
 - Se existe um par de números d < b e e  < b tal que d * e = b, conta mais 1 em h
 - Retira 17 de b e tenta de novo
 - H tem o valor 17000 - (qtd de primos entre b e c)
*/

import java.util.*;

public class Problem2 {

    static int from = 109900;
    static int to = 126900;

    public static void main(String[] args) {

        int count = 0;

        for (int i = from; i <= to; i += 17) {

            boolean flag = false;

            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) ++count;
        }

        System.out.println(count);

    }

}