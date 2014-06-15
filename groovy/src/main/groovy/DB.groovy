/**
 * Created by IntelliJ IDEA.
 * User: alexey
 * Date: 15.06.14
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
class DB {
    def object
    def resultQuery;

    def select(Closure c) {
        object = new QueryObject()
        TableQueryBuilder tableQueryBuilder = new TableQueryBuilder(object);
        c.delegate = tableQueryBuilder;
        c.resolveStrategy = Closure.DELEGATE_FIRST;
        c()
        resultQuery = new SQLBuilder().buildQuery(object);
    }

    class SQLBuilder {
        def buildQuery(QueryObject queryObject) {
            def o = queryObject;
            return "SELECT FROM $o.table WHERE $o.column $o.condition '$o.value'";
        }
    }
    // select * from TABLE where COLUMN1 LIKE VALUE1 or COLUMN2 LIKE
    class QueryObject {
        def table
        def column
        def condition
        def value
        def setCondition(def condition) {
            switch (condition) {
                case 'IS' :
                    this.condition = '='
                    break;
                default:
                    this.condition = condition
            }
        }

    }

    class TableQueryBuilder {
        def queryObject

        TableQueryBuilder(queryObject) {
            this.queryObject = queryObject
        }

        def invokeMethod(String name, args) {
            queryObject.table = name;
            ColumnQueryBuilder columnQueryBuilder = new ColumnQueryBuilder(object);
            args[0].resolveStrategy = Closure.DELEGATE_FIRST;
            args[0].delegate = columnQueryBuilder;
            args[0]();
        }
    }
    class ColumnQueryBuilder {
        def queryObject

        ColumnQueryBuilder(queryObject) {
            this.queryObject = queryObject
        }

        def invokeMethod(String name, args) {
            queryObject.column = name;
            WhereQueryBuilder whereQueryBuilder = new WhereQueryBuilder(object);
            args[0].resolveStrategy = Closure.DELEGATE_FIRST;
            args[0].delegate = whereQueryBuilder;
            args[0]();
        }
    }

    class WhereQueryBuilder {
        def queryObject

        WhereQueryBuilder(queryObject) {
            this.queryObject = queryObject
        }

        def invokeMethod(String name, args) {
            queryObject.condition = name;
            queryObject.value = args[0];
        }
    }
}
