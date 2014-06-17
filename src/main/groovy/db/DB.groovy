package db

import groovy.sql.Sql

/**
 * Created by IntelliJ IDEA.
 * collection.User: alexey
 * Date: 15.06.14
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
class DB {
    def queryObject = new QueryObject();

    def select(Closure c) {
        TableQueryBuilder tableQueryBuilder = new TableQueryBuilder(queryObject);
        c.delegate = tableQueryBuilder;
        c.resolveStrategy = Closure.DELEGATE_FIRST;
        c()

        def resultQuery = new SQLBuilder().buildQuery(queryObject);

        def sql = Sql.newInstance('jdbc:oracle:thin:@//conn', 'user', 'pass', 'oracle.jdbc.OracleDriver');
        def rows = sql.rows(resultQuery, [value: queryObject.value]);

        def rowsAsserter = new RowsAsserter(rows: rows);
        def asserts = queryObject.assertClosure;
        asserts.delegate = rowsAsserter;
        asserts.resolveStrategy = Closure.DELEGATE_FIRST;
        asserts()
    }

    class RowsAsserter {
        def rows;

        def getProperty(String name) {
            switch (name) {
                case "size":
                    rows.size()
                    break
                default:
                    if (rows.size > 1) throw new Exception("More than 1 row, columns unavailable!");
                    if (!rows[name]) throw new Exception("Column $name not found!")
                    rows[0][name]
            }

        }
    }

    class SQLBuilder {
        def buildQuery(QueryObject queryObject) {
            def o = queryObject;
            "SELECT * FROM $o.table WHERE $o.column $o.condition :value"
            // Ha, this doesn't work cause of possible SQL injection
//            return "SELECT * FROM $o.table WHERE $o.column $o.condition $o.value";
        }
    }

    class QueryObject {
        def table
        def column
        def condition
        def value
        def assertClosure

        def setCondition(def condition) {
            switch (condition) {
                case 'IS':
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
            queryObject.table = name
            ColumnQueryBuilder columnQueryBuilder = new ColumnQueryBuilder(DB.this.queryObject)
            args[0].resolveStrategy = Closure.DELEGATE_FIRST
            args[0].delegate = columnQueryBuilder
            args[0]()
        }
    }

    class ColumnQueryBuilder {
        def queryObject

        ColumnQueryBuilder(queryObject) {
            this.queryObject = queryObject
        }

        def invokeMethod(String name, args) {
            queryObject.column = name
            WhereQueryBuilder whereQueryBuilder = new WhereQueryBuilder(DB.this.queryObject)
            args[0].resolveStrategy = Closure.DELEGATE_FIRST
            args[0].delegate = whereQueryBuilder
            args[0]()
        }
    }

    class WhereQueryBuilder {
        def queryObject

        WhereQueryBuilder(queryObject) {
            this.queryObject = queryObject
        }

        def invokeMethod(String name, args) {
            queryObject.condition = name
            args[2].length();
            queryObject.value = args[0]
            queryObject.assertClosure = args[1]
        }
    }
}
