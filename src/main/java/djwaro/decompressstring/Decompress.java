package djwaro.decompressstring;
import java.util.*;

/*
 * @author David J. Waro
 */
public class Decompress {
    private String nums = "123456789";
    private String letters = "abcdefghijklmnopqrstuvwxyz";
    private ArrayList<String[]> stack = new ArrayList<String[]>();
    private ArrayList<Integer> depthList = new ArrayList<Integer>();
    private ArrayList<Integer> numList = new ArrayList<Integer>();
    private ArrayList<String> stringList = new ArrayList<String>();
    private String newString = "";
    
    Decompress() {
    }
    
    public String decomp(String str) {
        int[] bracketCounts = {0, 0};
        String[] split = str.split("");
        tryThree(bracketCounts, split, 0);
        
        return newString;
    }
    
    void tryThree(int[] bracketCounts, String[] split, int index) {
        System.out.println(bracketCounts[0]);
        System.out.println(bracketCounts[1]);
        
        int lCount = bracketCounts[0];
        int rCount = bracketCounts[1];
        
        // remove items from stack once we reach closure point
        if (lCount == rCount & stack.size() > 1) {
            String tempStr;
            String startStr = stack.get(stack.size()-1)[1]; // str of last item
            while (stack.size() > 1) {
                
                tempStr = "";
                int num = Integer.parseInt(stack.get(stack.size()-1)[0]); // num of last item
                String str = stack.get(stack.size()-2)[1]; // str of second to last item
                
                for (int i=0; i<num; i++) {
                    tempStr+=startStr;
                }
                str += tempStr;
                startStr = str;
                stack.remove(stack.size()-1); // remove last item from stack
            }
            stack.remove(stack.size()-1);
            newString += startStr;
        } else if (lCount == rCount & stack.size() == 1) {
            newString += stack.get(0)[1];
        }
        
        if (index < split.length) {
            String num = "";
            try {
                while (nums.contains(split[index])) {
                    num += split[index];
                    index++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}

            try {
                while (split[index].equals("[") | split[index].equals("]")) {
                    if (split[index].equals("[")){
                        bracketCounts[0] += 1;
                    } else {
                        bracketCounts[1] += 1;
                    }
                    index++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {}

            String holder = "";
            try {
                while (letters.contains(split[index])){
                    holder += split[index];
                        index++;
                    }
            } catch (ArrayIndexOutOfBoundsException e) {}
           

            if (!holder.equals("")) {
                String[] adder = {num, holder};
                stack.add(adder);
                tryThree(bracketCounts, split, index);
            }   
        }
    }
}
