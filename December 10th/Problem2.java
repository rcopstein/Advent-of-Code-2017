import java.util.*;

public class Problem2
{
    static int[] reverse(int[] list, int current, int length) {
        
        int[] aux = new int[length];
        for (int i = 0; i < length; ++i) aux[length - 1 - i] = list[(current + i) % list.length];
        for (int i = 0; i < length; ++i) list[(current + i) % list.length] = aux[i];
        return list;
        
    }
    
    public static void main(String[] args) {
        
        // Get lengths
        
        String input = "94,84,0,79,2,27,81,1,123,93,218,23,103,255,254,243"; // 50 Characters
        char[] inputchars = input.toCharArray();
        
        int[] lengths = new int[55];
        for (int i = 0; i < 50; ++i) { lengths[i] = inputchars[i]; }
        
        lengths[50] = 17;
        lengths[51] = 31;
        lengths[52] = 73;
        lengths[53] = 47;
        lengths[54] = 23;
        
        // Initialize List
        
        int[] list = new int[256];
        for (int i = 0; i < 256; ++i) { list[i] = i; }
        
        // Run 64 rounds
        
        int current = 0;
        int skip = 0;
        
        for (int round = 0; round < 64; ++round) {
            for (int i = 0; i < lengths.length; ++i) {
                
                list = reverse(list, current, lengths[i]);
                current = (current + lengths[i] + skip) % 256;
                ++skip;
                
            }
        }
        
        // Compress sparse hash
        
        int[] denseHash = new int[16];
        
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                denseHash[i] = denseHash[i] ^ list[i * 16 + j];
            }
            
            System.out.print(String.format("%02X", denseHash[i]));
        }
        
    }
}
