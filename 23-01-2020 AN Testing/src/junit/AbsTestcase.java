package junit;

import junit.framework.TestCase;
import org.junit.Assert;

public class AbsTestcase extends TestCase {
    public void testAdd(){
        int res = 2+3;
        Assert.assertEquals(4, res);
    }

    public void tearDown(){

    }
}
