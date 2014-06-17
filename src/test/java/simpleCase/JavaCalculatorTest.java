package simpleCase;

import org.junit.Test;

/**
 * (c) Swissquote 6/10/14
 *
 * @author oburov
 */
public class JavaCalculatorTest {
	@Test
	public void test() {
		assert 9 == new Calculator().multiply(3,3);
	}
}
