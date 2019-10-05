package djwaro.decompressstring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * @author David Waro
 */
public class DecompTest {
    
    public DecompTest() {
    }
    
     @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testDecomp() {
        Decompress decomp = new Decompress();
        String test1 = decomp.decomp("3[abc]4[ab]c");
        String test2 = decomp.decomp("a3[ab2[m]]a2[b]f");
        String test3 = decomp.decomp("2[t]3[a2[b]]");
        String test4 = decomp.decomp("b");
        String test5 = decomp.decomp("abcdefghij");
        String test6 = decomp.decomp("20[o]");
        String test7 = decomp.decomp("");
        String test8 = decomp.decomp("z1[y]1[x]1[w]v");
        
        // check tests
        assertEquals("abcabcabcababababc", test1);
        assertEquals("aabmmabmmabmmabbf", test2);
        assertEquals("ttabbabbabb", test3);
        assertEquals("b", test4);
        assertEquals("abcdefghij", test5);
        assertEquals("oooooooooooooooooooo", test6);
        assertEquals("", test7);
        assertEquals("zyxwv", test8);
    }
}
