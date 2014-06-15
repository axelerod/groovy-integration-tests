/**
 * Created by IntelliJ IDEA.
 * User: alexey
 * Date: 15.06.14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
class DbTest extends GroovyTestCase{
    def testSelect() {
        def db = new DB()
        def result = db.select {
            USER {
                NAME {
                    LIKE("BOB")
                }
            }
        };

        assert result == "SELECT FROM USER WHERE NAME LIKE 'BOB'" : "Query wrong"
    }

}

