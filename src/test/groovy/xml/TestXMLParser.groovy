package xml

/**
 * (c) Swissquote 6/17/14
 * @author oburov
 */
class TestXMLParser extends GroovyTestCase{
    static def CAR_RECORDS = '''
    <records>
      <car name='HSV Maloo' make='Holden' year='2006'>
        <country>Australia</country>
        <record type='speed'>Production Pickup Truck with speed of 271kph</record>
      </car>
      <car name='P50' make='Peel' year='1962'>
        <country>Isle of Man</country>
        <record type='size'>Smallest Street-Legal Car at 99cm wide and 59 kg in weight</record>
      </car>
      <car name='Royale' make='Bugatti' year='1931'>
        <country>France</country>
        <record type='price'>Most Valuable Car at $15 million</record>
      </car>
    </records>
  '''

    void test() {
        def records = new XmlParser().parseText(CAR_RECORDS)
        assert records.car.size() == 3
        assert records.depthFirst().size() == 10
        def firstRecord = records.car[0]
        assert 'car' == firstRecord.name()
        assert 'Holden' == firstRecord.'@make'
        assert 'Australia' == firstRecord.country.text()
        assert 2 == records.car.findAll { it.'@make'.contains('e') }.size() // 2 cars have an 'e' in the make
        // makes of cars that have an 's' followed by an 'a' in the country
        assert ['Holden', 'Peel'] == records.car.findAll { it.country.text() =~ '.*s.*a.*' }.'@make'
        assert ['Royale', 'P50', 'HSV Maloo'] == records.car.sort { it.'@year'.toInteger() }.'@name'
    }
}
