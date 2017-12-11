import java.util.*;

public class Problem1
{
    static int[] reverse(int[] list, int current, int length) {
        
        int[] aux = new int[length];
        for (int i = 0; i < length; ++i) aux[length - 1 - i] = list[(current + i) % list.length];
        for (int i = 0; i < length; ++i) list[(current + i) % list.length] = aux[i];
        return list;
        
    }
    
    public static void main(String[] args) {
        
        int[] lengths = new int[] { 94,84,0,79,2,27,81,1,123,93,218,23,103,255,254,243 };
        
        int[] list = new int[256];
        for (int i = 0; i < 256; ++i) { list[i] = i; }
        
        int current = 0;
        int skip = 0;
        
        for (int i = 0; i < lengths.length; ++i) {
            
            list = reverse(list, current, lengths[i]);
            current = (current + lengths[i] + skip) % 256;
            ++skip;
            
        }
        
        System.out.println(list[0] * list[1]);
        
    }
}
