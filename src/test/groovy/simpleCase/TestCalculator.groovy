package simpleCase

import org.junit.Test

class TestCalculator {
    @Test
    void test() {
        assert 9 == new Calculator().multiply(3,3);
    }
}