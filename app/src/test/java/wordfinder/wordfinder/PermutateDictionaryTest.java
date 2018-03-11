package wordfinder.wordfinder;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;

public class PermutateDictionaryTest {
    @Test
    public void testSpecialSignÄ() throws Exception {
        List<String> result = PermutateDictionary.go("aalähnlich");
        assertNotEquals(0, result.size());
    }

    @Test
    public void testSpecialSignÖ() throws Exception {
        List<String> result = PermutateDictionary.go("aalförmige");
        assertNotEquals(0, result.size());
    }

    @Test
    public void testSpecialSignÜ() throws Exception {
        List<String> result = PermutateDictionary.go("aalsüppchen");
        assertNotEquals(0, result.size());
    }

    @Test
    public void testSpecialSignß() throws Exception {
        List<String> result = PermutateDictionary.go("abbaustoß");
        assertNotEquals(0, result.size());
    }

    @Test
    public void testBasic() throws Exception {
        List<String> result = PermutateDictionary.go("aachen");
        assertEquals(1, result.size());
    }

    @Test
    public void testBasicLessLetters() throws Exception {
        List<String> result = PermutateDictionary.go("baachen", "6");
        assertNotEquals(0, result.size());
        assertTrue(result.contains("aachen"));
    }


    @Test
    public void test_StringToInt_Null() {
        assertEquals(5, PermutateDictionary.stringToInt("abcde", null));
    }

    @Test
    public void test_StringToInt_NoString() {
        assertEquals(5, PermutateDictionary.stringToInt("abcde", "a"));
    }

    @Test
    public void test_StringToInt_0() {
        assertEquals(5, PermutateDictionary.stringToInt("abcde", "0"));
    }

    @Test
    public void test_StringToInt_2() {
        assertEquals(2, PermutateDictionary.stringToInt("abcde", "2"));
    }
}
