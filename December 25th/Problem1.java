import java.util.*;

public class Problem1 {

    static int count;
    static int cursor;
    static HashSet<Integer> ones = new HashSet<>();
    
    static int state; // 0 e 5
    static int[][] movement; // 1 ou -1
    static int[][] newState; // 0 e 5
    static int[][] writeValue; // 0 ou 1
    
    static int steps = 12173597;
    
    static void fill() {
        
        state = 0; // A
        
        movement = new int[6][2];
        newState = new int[6][2];
        writeValue = new int[6][2];
        
        movement[0][0] = 1;
        movement[0][1] = -1;
        newState[0][0] = 1;
        newState[0][1] = 2;
        writeValue[0][0] = 1;
        writeValue[0][1] = 0;
        
        movement[1][0] = -1;
        movement[1][1] = 1;
        newState[1][0] = 0;
        newState[1][1] = 3;
        writeValue[1][0] = 1;
        writeValue[1][1] = 1;
        
        movement[2][0] = 1;
        movement[2][1] = -1;
        newState[2][0] = 0;
        newState[2][1] = 4;
        writeValue[2][0] = 1;
        writeValue[2][1] = 0;
        
        movement[3][0] = 1;
        movement[3][1] = 1;
        newState[3][0] = 0;
        newState[3][1] = 1;
        writeValue[3][0] = 1;
        writeValue[3][1] = 0;
        
        movement[4][0] = -1;
        movement[4][1] = -1;
        newState[4][0] = 5;
        newState[4][1] = 2;
        writeValue[4][0] = 1;
        writeValue[4][1] = 1;
        
        movement[5][0] = 1;
        movement[5][1] = 1;
        newState[5][0] = 3;
        newState[5][1] = 0;
        writeValue[5][0] = 1;
        writeValue[5][1] = 1;
        
    }
    
    static void fill2() {
        
        state = 0; // A
        steps = 6;
        
        movement = new int[2][2];
        newState = new int[2][2];
        writeValue = new int[2][2];
        
        movement[0][0] = 1;
        movement[0][1] = -1;
        newState[0][0] = 1;
        newState[0][1] = 1;
        writeValue[0][0] = 1;
        writeValue[0][1] = 0;
        
        movement[1][0] = -1;
        movement[1][1] = 1;
        newState[1][0] = 0;
        newState[1][1] = 0;
        writeValue[1][0] = 1;
        writeValue[1][1] = 1;
        
    }
    
    public static void main(String[] args) {
        
        fill();
        
        for (int i = 0; i < steps; ++i) {
            
           int valor = 0;
           if (ones.contains(cursor)) valor = 1;
           
           int val = writeValue[state][valor];
           if (val == 1 && valor == 0) { ++count; ones.add(cursor); }
           if (val == 0 && valor == 1) { --count; ones.remove(cursor); }
           
           cursor += movement[state][valor];
           state = newState[state][valor];
        }
        
        System.out.println(count);
        
    }
}
