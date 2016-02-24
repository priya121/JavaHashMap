package test;

import main.PriyasHash;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PriyasHashTest {

    @Test
    public void addsAKeyValuePairAndSearchesForValueIfKeyGiven() {
        PriyasHash<Integer, String> hash = new PriyasHash<>();
        hash.add(1, "one");
        assertEquals("one", hash.search(1));
    }

    @Test
    public void doesNotWriteOverAnExistingKeyValuePairInTheSameBucket() {
        PriyasHash<Integer, String> hash = new PriyasHash<>();
        hash.add(7, "seven");
        hash.add(1, "one");
        assertEquals("seven", hash.search(7));
        assertEquals("one", hash.search(1));
    }

    @Test
    public void canFindAKeyValuePairFromThreeEntriesWithTheSameHashcode() {
        PriyasHash<Integer, String> hash = new PriyasHash<>();
        hash.add(6, "six");
        hash.add(7, "seven");
        hash.add(10, "ten");
        hash.add(13, "thirteen");
        hash.add(1, "one");
        assertEquals("thirteen", hash.search(13));
        assertEquals("ten", hash.search(10));
        assertEquals("seven", hash.search(7));
        assertEquals("one", hash.search(1));
        assertEquals("six", hash.search(6));
    }
}