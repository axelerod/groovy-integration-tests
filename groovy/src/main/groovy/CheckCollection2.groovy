class CheckCollection2 extends  GroovyTestCase{

    def checkObjectField = {field,constraint, assertMessage,value ->
        assert value."$field".length() > constraint : assertMessage};
    def checkPassportLength = checkObjectField.curry('passportId', 2, "Passport id not less 2 symbols!")
    def checkLisenceNumber = checkObjectField.curry('lisenceNumber', 5, 'lisenceNumber id not less 5 symbols!')

    def test() {
        def list = new GetCollection().getCollection();
        list.each(checkPassportLength);
        list.each(checkLisenceNumber);

        //or
        def allChecks = { checkPassportLength(it); checkLisenceNumber(it)};
        list.each {allChecks};
    }
}