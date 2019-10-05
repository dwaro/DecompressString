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
        String newString1 = decomp.decomp("3[abc]4[ab]c");
        String newString2 = decomp.decomp("a3[ab2[m]]a2[b]f");
        String newString3 = decomp.decomp("2[t]3[a2[b]]");
        assertEquals("abcabcabcababababc", newString1);
        assertEquals("aabmmabmmabmmabbf", newString2);
        assertEquals("ttabbabbabb", newString3);
    }
}
