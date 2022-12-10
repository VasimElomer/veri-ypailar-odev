package hafta11_lab;

import static hafta11_lab.Canonical_Huffman.testCanonicalHC;
import java.io.IOException;

public class Hafta11_lab {

    public static void main(String[] args)throws IOException {
        
        int n = 4;
        char[] chararr = { 'a', 'b', 'c', 'd' };
        int[] freq = { 10, 1, 15, 7 };
        testCanonicalHC(n, chararr, freq);
        
        
    }
    
}
