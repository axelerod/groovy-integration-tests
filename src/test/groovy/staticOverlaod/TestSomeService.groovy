package staticOverlaod

import staticOverload.SomeService
import staticOverload.anotherPackage.ThirdPartyUtils

/**
 * (c) Swissquote 6/17/14
 * @author oburov
 */
class TestSomeService extends GroovyTestCase{

    void test() {
        ThirdPartyUtils.metaClass.static.someFancyFormatting = { String s -> return "DDD"} // magic, typed closure argument is required

        SomeService service = new SomeService()
        def toFormat = "String"

//        assert toFormat == service.format(toFormat)
    }
}
