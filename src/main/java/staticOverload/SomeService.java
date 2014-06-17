package staticOverload;

import staticOverload.anotherPackage.ThirdPartyUtils;

/**
 * (c) Swissquote 6/17/14
 *
 * @author oburov
 */
public class SomeService {
	public String format(String s) {
		String formatted = ThirdPartyUtils.someFancyFormatting(s);
		if (formatted.length() > 5) {
			return formatted.substring(0,5);
		}
		return formatted;
	}
}
