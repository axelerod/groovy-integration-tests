package prettyAssert;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author oburov
 */
public class JavaAssertLists {
	@Test
	public void test() {
		ArrayList list = new ArrayList(3){
			{
				add(1);
				add(2);
				add(3);
			}
		};

		List another = Arrays.asList(1,3,7);

		Assert.assertEquals(list, another);
	}
}
