package djwaro.decompressstring;
import java.util.*;

/*
 * @author David J. Waro
 */
public class Decompress {
    private String brackets = "[]";
    private String nums = "123456789";
    private String letters = "abcdefghijklmnopqrstuvwxyz";
    private int index = 0;
    
    Decompress() {
    }
    
    public String decomp(String str) {
        // construct array list from string to iterate
        String split[] = str.split("");
        index = 0;
        String newString = "";
        String num = "";
        newString = recurseString(split, newString, index, num);
        
        return newString;
    }
    
    public String recurseString(String[] split, String newString, int index, String num){
        
        // letters at level 0
        while (letters.contains(split[index])) {
            newString += split[index];
            index++;
        }
        
        // number at level 0
        while (nums.contains(split[index])) {
            num += split[index];
            index++;
        }
        
        if (split[index].equals("]")) {
            
        }
        
        return "asdfsa";
    }
}
