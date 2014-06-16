package prettyAssert

class AssertLists extends GroovyTestCase{
    void  test() {
        def a = 1
        def b = 2
        def list = [1,3,5]
        def anotherList = [1,3,7]
//        assert a == b : "Check of a==b"
        assert list == anotherList : ""
    }

}
