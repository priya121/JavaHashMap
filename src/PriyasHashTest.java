import junit.framework.Assert;
import org.junit.Test;

public class PriyasHashTest {

    @Test
    public void implementsASimpleHashMap() {
        PriyasHash hash = new PriyasHash();
        hash.add(1, "one");
        Assert.assertEquals("one", hash.search(1));
    }
}