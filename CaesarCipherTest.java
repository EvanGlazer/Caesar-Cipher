import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCipherTest {

    @Test
    public void testLet2nat() throws Exception {
        assertEquals(0, CaesarCipher.let2nat('a'));
    }

    @Test
    public void testNat2let() throws Exception {
        assertEquals('a', CaesarCipher.nat2let(0));
    }

    @Test
    public void testShift() throws Exception {
        assertEquals('d', CaesarCipher.shift(3,'a'));
    }

    @Test
    public void testEncode() throws Exception {
        assertEquals("kdvnhoolvixq", CaesarCipher.encode(3, "haskellisfun"));
    }

    @Test
    public void testDecode() throws Exception {
        assertEquals("haskellisfun", CaesarCipher.decode(3, "kdvnhoolvixq"));
      
    }

    @Test
    public void testLowers() throws Exception {
        assertEquals(12, CaesarCipher.lowers("haskellisfun"));
    }

    @Test
    public void testCount() throws Exception {
        assertEquals(2, CaesarCipher.count('s', "haskellisfun"));
    }

    @Test
    public void testPercent() throws Exception {
        assertEquals(16.6667, CaesarCipher.percent(2,12), .0001);
    }

    @Test
    public void testFreqs() throws Exception {
        assertArrayEquals(new double[]{8.33333,0.0,0.0,0.0,8.33333,8.33333,0.0,8.33333, 8.33333,0.0,8.33333,16.6667,0.0,8.33333,0.0,0.0,0.0,0.0,16.6667,0.0,8.33333,0.0,0.0,0.0,0.0,0.0}, CaesarCipher.freqs("haskellisfun"), .0001);
    }

    @Test
    public void testRotate() throws Exception {
    	 assertArrayEquals(new double[]{0.0,0.0,8.33333,8.33333,0.0,8.33333, 8.33333,0.0,8.33333,16.6667,0.0,8.33333,0.0,0.0,0.0,0.0,16.6667,0.0,8.33333,0.0,0.0,0.0,0.0,0.0,8.33333,0.0}, CaesarCipher.rotate(2, CaesarCipher.freqs("haskellisfun")), .0001);
        
    }

    @Test
    public void testChisqr() throws Exception {
        assertEquals(202.616, CaesarCipher.chisqr(CaesarCipher.freqs("haskellisfun")), .001);

    }

    @Test
    public void testPosition() throws Exception {
        assertEquals(2, CaesarCipher.position(5.0, new double[]{1.0, 3.0, 5.0, 7.0, 11.0}));
    }

    @Test
    public void testCrack() throws Exception {
        assertEquals("haskellisfun", CaesarCipher.crack(CaesarCipher.encode(3, "haskellisfun")));
    }
}