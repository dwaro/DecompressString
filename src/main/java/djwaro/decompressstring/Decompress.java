package djwaro.decompressstring;
import java.util.*;

/*
 * @author David J. Waro
 *
 *  This class handles logic that takes a compressed string consisting of letters,
 *  numbers, and brackets "[" or "]" and decompresses the string. The following
 *  compressed string: "ft2[d2[a]]y" yields the string "ftdaadaay".
 *
 */
public class Decompress {
    private final String nums;
    private final String letters;
    private ArrayList<String[]> stack = new ArrayList<String[]>();
    private String newString;
    private String tempStr;
    private String num;
    private int level;
    
    Decompress() {
        nums = "123456789";
        letters = "abcdefghijklmnopqrstuvwxyz";
        newString = "";
        tempStr = "";
        num = "1";
        level = 1;
    }
    
    /*
    *
    * Method decomp encompasses the logic to decompress a string, given a
    * compressed string "str" as input.
    *
    */
    public String decomp(String str) {
        newString = "";
        tempStr = "";
        num = "1";
        level = 1;
        stack.clear();
        
        String[] split = str.split("");
        iterateString(split);
        
        return newString;
    }
    
    /*
    *
    *   This method iterates over the string. There are three main pieces:
    *   - if the char at index i is a letter, grow a substring
    *   - if the char at index i is a number, grow the number
    *   - if the char at index i is a bracket [ or ], increase the depth of the 
    *     string that we're on. If the depth level is 1, call the popstack method
    *     to grow the newString
    *
    */
    private void iterateString(String[] split) {
        String grow_str = ""; // holds temp string
        String grow_num = ""; // holds temp number
        
        // iterate over string
        for (int i = 0; i < split.length; i++) {
            grow_str = "";
            grow_num = "";
            
            // grow the substring
            try {
                while (letters.contains(split[i])) {
                    grow_str += split[i];
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
            
            // add the substring to the stack with its respective count
            if (!grow_str.equals("") & !num.equals("")) {
                String[] sequence = {num, grow_str};
                stack.add(sequence);
            }
            num = "";
            
            // find numbers in the string
            try {
                while (nums.contains(split[i])) {
                    grow_num += split[i];
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
            num = grow_num;
            
            // increase or decrease depth, and if depth == 1, pop the stack
            if  (i < split.length) {
                if ((split[i].equals("[") | split[i].equals("]"))) {
                    if (split[i].equals("[")) {
                        level++;
                    } else if (split[i].equals("]")) {
                        level--;
                    }
                    if (level == 1) {
                        popstack();
                    }
                }
            }
        }
        
        // safety measure to catch if stack is still populated before closing finishing
        while (stack.size() > 0) {
            popstack();
        }
    }
    
    /*
    * 
    *   This method will grow a new substring to be added to newString for all the
    *   elements within the stack. The stack holds String[] elements, with the 0
    *   position holding the number of times the substring should occur and position
    *   1 holds the respective str.
    *
    */
    private void popstack() {
        int count = Integer.parseInt(stack.get(stack.size()-1)[0]); // # of repititions
        String str = stack.get(stack.size()-1)[1];  // str to add in
        
        String poptmp1 = str + tempStr;
        String poptmp2 = poptmp1;
        
        // grow the substring
        for (int i = 0; i < count - 1; i++) {
            poptmp2 += poptmp1;
        }
        
        tempStr = poptmp2;
        stack.remove(stack.size()-1);
        
        // if stack is empty continue forward in the compressed string
        if (stack.isEmpty()) {
            newString += tempStr;
            tempStr = "";
            num = "1";
        } else {        // the stack is still populated
            popstack();
        }
    } 
}
