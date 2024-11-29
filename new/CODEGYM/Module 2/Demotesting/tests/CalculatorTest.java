package tests;

import org.junit.jupiter.api.Test;
import Source.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void testAdd() {
        int a = 3;
        int b = 4;

        int actual = a + b;

        int result = Calculator.add(a, b);
        assertEquals(result, actual);
    }

    public void testAddWithZero() {
        int a = 3;
        int b = 0;

        int actual = a + b;

        int result = Calculator.add(a, b);
        assertEquals(result, actual);
    }

    public void testAddWithNumberLess0() {
        int a = -3;
        int b = -9;

        int actual = a + b;

        int result = Calculator.add(a, b);
        assertEquals(result, a + b);
    }
}
