package djwaro.decompressstring;
import java.util.*;

/*
 * @author David J. Waro
 */
public class Decompress {
    private String nums = "123456789";
    private String letters = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<String[]> stack = new ArrayList<String[]>();
    private String newString;
    private String tempStr;
    private String num;
    private int level;
    
    Decompress() {
        newString = "";
        tempStr = "";
        num = "1";
        level = 1;
    }
    
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
    
    void iterateString(String[] split) {
        String grow_str = "";
        String grow_num = "";
        
        for (int i = 0; i < split.length; i++) {
            grow_str = "";
            grow_num = "";
            
            System.out.println("newString: " + newString);
            
            try {
                while (letters.contains(split[i])) {
                    grow_str += split[i];
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
            
            if (!grow_str.equals("") & num != "") {
                String[] sequence = {num, grow_str};
                stack.add(sequence);
            }
            
            num = "";
            
            try {
                while (nums.contains(split[i])) {
                    grow_num += split[i];
                    i++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}
            
            num = grow_num;
            
            if  (i < split.length) {
                if (split[i].equals("[")) {
                    level++;
                } else if (split[i].equals("]")) {
                    level--;
                    popstack();
                }
            }
        }
    }
    
    void popstack() {
        int count = 1;
        String lastStr = "";
        String thisStr = "";
        String temp2 = "";
        
        if (stack.size() > 2) {
            String[] c = stack.get(stack.size()-1);
            count = Integer.parseInt(c[0]);
            lastStr = c[1];
            for (int j = 0; j < count; j++) {
                tempStr += lastStr;
            }
            stack.remove(stack.size()-1);
        } else if (stack.size() == 2) {
            while (stack.size() > 0) {
                thisStr = stack.get(stack.size()-1)[1];
                thisStr += tempStr;
                temp2 = thisStr;
                if (stack.size() == 2) {
                    for (int j = 0; j < Integer.parseInt(stack.get(stack.size()-1)[0]) - 1; j++) {
                        thisStr += temp2;
                    }
                    tempStr = thisStr;
                } else {
                    this.newString += thisStr;
                    tempStr = "";
                    num = "1";
                }
                stack.remove(stack.size()-1);
            }
        }
    } 
}
