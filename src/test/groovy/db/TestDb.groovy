package db

/**
 * Created by IntelliJ IDEA.
 * collection.User: alexey
 * Date: 15.06.14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
class TestDb extends GroovyTestCase{
    void setUp() {
        println("setup")
        new DB().ddl(
                '''
                CREATE TABLE USER_GROOVY
                (
                    ID int,
                    NAME varchar(255),
                    SURNAME varchar(255)
                )
                '''
        )
        new DB().dml("INSERT INTO USER_GROOVY VALUES (1, 'Bob', 'Dylan')")
    }

    void tearDown() {
        println("tear")
        new DB().ddl(
                '''
                DROP TABLE USER_GROOVY
                '''
        )
    }


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

