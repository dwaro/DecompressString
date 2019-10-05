package djwaro.decompressstring;

/*
 * @author David J. Waro
 */
public class Main {
    public static void main(String[] args) {
        Decompress decomper = new Decompress();
        String compressed = "a3[ab2[m]]a2[b]f";
        String newString = decomper.decomp(compressed);
        System.out.println("---------------------------------");
        System.out.println("Compressed String: " + compressed);
        System.out.println("Decompressed String: " + newString);
        System.out.println("---------------------------------");
    }
}
