package simpleCase

import org.junit.Test

class CalculatorTest {
    @Test
    void test() {
        assert 91 == new Calculator().multiply(3,3);
    }
}