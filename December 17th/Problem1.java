import java.util.*;

public class Problem1 {

    static class Node {

        int value;
        Node next;

        public Node(int value) {

            this.value = value;
        
        }

    }

    public static void main(String[] args) {

        int jumpBy = 367;

        Node current = new Node(0);
        current.next = current;

        for (int i = 1; i <= 2017; ++i) {

            Node aux = current;
            for (int j = 0; j < jumpBy; ++j) aux = aux.next;

            Node add = new Node(i);
            add.next = aux.next;
            aux.next = add;

            current = add;

        }

        System.out.println(current.value);
        System.out.println(current.next.value);

    }

}