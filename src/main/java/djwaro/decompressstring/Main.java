package djwaro.decompressstring;

/*
 * @author David J. Waro
 */
public class Main {
    public static void main(String[] args) {
        Decompress decomp = new Decompress();
        //Decompress decomp = new Decompress("3[abc]4[ab]c");
        String newString = decomp.decomp("3[abc]4[ab]c");
        System.out.println(newString);
    }
}
