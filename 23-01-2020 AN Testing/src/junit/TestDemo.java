package junit;

import org.junit.Assert;
import org.junit.Test;

public class TestDemo {
    @Test
    public void testString() {
        String str = "Logesh is a smart boy!";
        Assert.assertEquals("Logesh is a smart boy!", str);
    }

    @Test
    public void testAdd() {
        int a = 10;
        int b = 20;
        Assert.assertEquals(20, a + b);
    }
}
