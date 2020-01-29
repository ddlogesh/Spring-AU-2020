package calc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd() {
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0, 20.0)).thenReturn(30.00);
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);
        when(calcService.multiply(7.0, 8.0)).thenReturn(56.0);
        when(calcService.divide(21.0, 7.0)).thenReturn(3.0);
        when(calcService.modulus(23.0, 7.0)).thenReturn(2.0);

        //test the add functionality
        Assert.assertEquals(calcService.add(10.0, 20.0), 30.0, 0);
        Assert.assertEquals(calcService.subtract(20.0, 10.0), 10.0, 0);
        Assert.assertEquals(calcService.multiply(7.0, 8.0), 56.0, 0);
        Assert.assertEquals(calcService.divide(21.0, 7.0), 3.0, 0);
        Assert.assertEquals(calcService.modulus(23.0, 7.0), 2.0, 0);

        InOrder inOrder = inOrder(calcService);

        inOrder.verify(calcService).add(10.0, 20.0);
        inOrder.verify(calcService).subtract(20.0, 10.0);
        inOrder.verify(calcService).multiply(7.0, 8.0);
        inOrder.verify(calcService).divide(21.0, 7.0);
        inOrder.verify(calcService).modulus(23.0, 7.0);

        verify(calcService, times(3)).add(10.0, 20.0); // fails
        verify(calcService, times(1)).subtract(20.0, 10.0);
        verify(calcService, times(1)).multiply(7.0, 8.0);
        verify(calcService, times(2)).divide(21.0, 7.0); // fails
        verify(calcService, times(1)).modulus(23.0, 7.0);
    }
}