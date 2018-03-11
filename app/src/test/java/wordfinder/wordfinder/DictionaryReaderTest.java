package wordfinder.wordfinder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DictionaryReaderTest {
    @Test
    public void testBasicReaderFunctionality() {
        DictionaryReader reader = new DictionaryReader("dict.txt");
        assertTrue(reader.openFile());
        assertEquals("aa", reader.getEntry());
    }

    @Test
    public void testDictionaryWithOneEntry() {
        DictionaryReader reader = new DictionaryReader("/home/basti/dev/Android/TestApplication/app/src/main/res/oneDict.txt");
        assertTrue(reader.openFile());
        assertEquals("asdf", reader.getEntry());
        assertNull(reader.getEntry());
    }

    @Test
    public void testDictionarySpecialSign() {
        DictionaryReader reader = new DictionaryReader("/home/basti/dev/Android/TestApplication/app/src/main/res/specialDict.txt");
        assertTrue(reader.openFile());
        assertEquals("äöüß", reader.getEntry());
        assertNull(reader.getEntry());
    }
}