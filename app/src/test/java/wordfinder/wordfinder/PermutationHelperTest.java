package wordfinder.wordfinder;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PermutationHelperTest {
    @Test
    public void testFaculty0() {
        assertEquals(1, PermutationHelper.faculty(0));
    }

    @Test
    public void testFaculty_1() {
        assertEquals(1, PermutationHelper.faculty(1));
    }

    @Test
    public void testFaculty_2() {
        assertEquals(2, PermutationHelper.faculty(2));
    }

    @Test
    public void testFaculty_3() {
        assertEquals(6, PermutationHelper.faculty(3));
    }

    @Test
    public void testFaculty_10() {
        assertEquals(3628800, PermutationHelper.faculty(10));
    }

    @Test
    public void testKillElement_FirstElementSize2() {
        char[] arr = {'a', 'b'};
        char[] result = PermutationHelper.killElement(arr, 0);
        assertEquals(1, result.length);
        assertEquals('b', result[0]);
    }

    @Test
    public void testKillElement_SecondElementSize2() {
        char[] arr = {'a', 'b'};
        char[] result = PermutationHelper.killElement(arr, 1);
        assertEquals(1, result.length);
        assertEquals('a', result[0]);
    }

    @Test
    public void testPermutate_OneSign() {
        Map<String, Boolean> result = PermutationHelper.permutate("a");
        assertEquals(1, result.size());
        assertTrue(result.get("a"));
        assertNull(result.get("b"));
    }

    @Test
    public void testPermutate_TwoSigns() {
        Map<String, Boolean> result = PermutationHelper.permutate("ab");
        assertEquals(2, result.size());
        assertTrue(result.get("ab"));
        assertTrue(result.get("ba"));
        assertNull(result.get("a"));
        assertNull(result.get("b"));
    }

    @Test
    public void testPermutate_ThreeSigns() {
        Map<String, Boolean> result = PermutationHelper.permutate("abc");
        assertEquals(6, result.size());
        assertTrue(result.get("abc"));
        assertTrue(result.get("acb"));
        assertTrue(result.get("bac"));
        assertTrue(result.get("bca"));
        assertTrue(result.get("cab"));
        assertTrue(result.get("cba"));
        assertNull(result.get("a"));
        assertNull(result.get("b"));
        assertNull(result.get("c"));
    }

    @Test
    public void testPermutate_TenSigns() {
        Map<String, Boolean> result = PermutationHelper.permutate("abcdefghij");
        assertEquals(PermutationHelper.faculty(10), result.size());
    }

    @Test
    public void testPermutate_SpecialSign() {
        Map<String, Boolean> result = PermutationHelper.permutate("aß");
        assertEquals(PermutationHelper.faculty(2), result.size());
        assertTrue(result.get("aß"));
        assertTrue(result.get("ßa"));
    }
}