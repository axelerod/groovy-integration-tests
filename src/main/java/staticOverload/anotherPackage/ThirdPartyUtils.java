package staticOverload.anotherPackage;

import java.util.Date;

/**
 * (c) Swissquote 6/17/14
 *
 * @author oburov
 */
public class ThirdPartyUtils {
	public static String someFancyFormatting(String s) {
		return doLogic(s);
	}

	private static String doLogic(String s) {
		return new Date().toString() + s;
	}


}
