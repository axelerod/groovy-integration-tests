package db

/**
 * Created by IntelliJ IDEA.
 * collection.User: alexey
 * Date: 15.06.14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
class TestDb extends GroovyTestCase{
    void test() {
        def db = new DB()
        def result = db.select {
            USER_GROOVY {                           // table
                NAME {                              // column
                    LIKE("Bob") {                   // condition
                        assert size == 1            // asserts
                        assert SURNAME == "Dylan"
                        assert ID == 1
                    }
                }
            }
        };
    }

}

