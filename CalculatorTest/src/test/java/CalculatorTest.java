import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test (expected = NullPointerException.class)
    public void evaluate() {
        Calculator.evaluate("(  -- 3) * ( 4 / 4");
    }
}