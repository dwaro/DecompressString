package djwaro.decompressstring;

/*
 * @author David J. Waro
 */
public class Main {
    public static void main(String[] args) {
        Decompress decomper = new Decompress();
        //Decompress decomp = new Decompress("3[abc]4[ab]c");
        String newString = decomper.decomp("a3[ab2[m]]a2[b]f");
        String newString2 = decomper.decomp("2[t]3[a2[b]]");
        System.out.println("--------------");
        System.out.println(newString);
        System.out.println(newString2);
        System.out.println("--------------");
        
    }
}
