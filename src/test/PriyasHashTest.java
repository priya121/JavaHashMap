package test;

import junit.framework.Assert;
import main.PriyasHash;
import org.junit.Test;

public class PriyasHashTest {

    @Test
    public void addsAKeyValuePairAndSearchesForValueIfKeyGiven() {
        PriyasHash hash = new PriyasHash();
        hash.add(1, "one");
        Assert.assertEquals("one", hash.search(1));
    }

    @Test
    public void doesNotWriteOverAnExisitingKeyValuePairInTheSameBucket() {
        PriyasHash hash = new PriyasHash();
        hash.add(7, "seven");
        hash.add(1, "one");
        Assert.assertEquals("seven", hash.search(7));
        Assert.assertEquals("one", hash.search(1));
    }

    @Test
    public void canFindAKeyValuePairFromThreeEntriesWithTheSameHashcode() {
        PriyasHash hash = new PriyasHash();
        hash.add(6, "six");
        hash.add(7, "seven");
        hash.add(10, "ten");
        hash.add(13, "thirteen");
        hash.add(1, "one");
        Assert.assertEquals("thirteen", hash.search(13));
        Assert.assertEquals("ten", hash.search(10));
        Assert.assertEquals("seven", hash.search(7));
        Assert.assertEquals("one", hash.search(1));
    }
}