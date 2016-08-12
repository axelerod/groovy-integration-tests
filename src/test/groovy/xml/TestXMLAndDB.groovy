package xml

import db.DB

class TestXMLAndDB extends GroovyTestCase {
    static def CAR_RECORDS = '''
    <records>
      <car name='HSV Maloo' make='Holden' year='2006'>
        <country>Australia</country>
        <record type='speed'>Production Pickup Truck with speed of 271kph</record>
      </car>
    </records>
  '''

    void setUp() {
        println("setup")
        new DB().ddl(
                '''
                CREATE TABLE CARS
                (
                    ID int,
                    NAME varchar(255),
                    COUNTRY varchar(255),
                    YEAR varchar(255)
                )
                '''
        )
        new DB().dml("INSERT INTO CARS VALUES (1, 'HSV Maloo', 'Australia', '2006')")
    }

    void tearDown() {
        println("tear")
        new DB().ddl(
                '''
                DROP TABLE CARS
                '''
        )
    }

    void test() {
        def records = new XmlParser().parseText(CAR_RECORDS)
        DB db = new DB();
        records.car.each {
            def car = it
            db.select {
                CARS {                                          // table
                    NAME {                                      // column
                        IS(car.'@name') {                       // condition
                            assert COUNTRY == car.country.text()// asserts
                            assert YEAR == car.'@year'
                        }
                    }
                }
            }
        }
    }
}

