package junit;

import org.junit.Assert;
import org.junit.Test;

public class TestDemo2 {
    @Test
    public void testString() {
        String str = "Logesh is a smart boy!";
        Assert.assertEquals("Logesh is a smart boy", str);
    }
}
