package djwaro.decompressstring;

/*
 * @author David J. Waro
 */
public class Main {
    public static void main(String[] args) {
        Decompress decomp = new Decompress();
        //Decompress decomp = new Decompress("3[abc]4[ab]c");
        String newString = decomp.decomp("a3[ab2[m]]a2[b]f");
        System.out.println(newString);
    }
}
