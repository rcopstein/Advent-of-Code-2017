import java.util.*;

public class KnotHash
{
    static int[] reverse(int[] list, int current, int length) {
        
        int[] aux = new int[length];
        for (int i = 0; i < length; ++i) aux[length - 1 - i] = list[(current + i) % list.length];
        for (int i = 0; i < length; ++i) list[(current + i) % list.length] = aux[i];
        return list;
        
    }
    
    public static String hash(String input) {
        
        // Get lengths
        
        char[] inputchars = input.toCharArray();
        
        int[] lengths = new int[inputchars.length + 5];
        for (int i = 0; i < inputchars.length; ++i) { lengths[i] = inputchars[i]; }
        
        lengths[inputchars.length + 0] = 17;
        lengths[inputchars.length + 1] = 31;
        lengths[inputchars.length + 2] = 73;
        lengths[inputchars.length + 3] = 47;
        lengths[inputchars.length + 4] = 23;
        
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
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                denseHash[i] = denseHash[i] ^ list[i * 16 + j];
            }
            
            builder.append(String.format("%02X", denseHash[i]));
        }

        return builder.toString();
        
    }
}
