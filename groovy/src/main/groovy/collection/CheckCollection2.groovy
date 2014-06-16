package collection

class CheckCollection2 extends GroovyTestCase {

    def checkObjectField = { field, constraint, assertMessage, value ->
        assert value."$field".length() > constraint: assertMessage
    };
    def checkPassportLength = checkObjectField.curry('passportId', 2, "Passport id not less 2 symbols!")
    def checkLicenceNumber = checkObjectField.curry('licenceNumber', 5, 'licenceNumber id not less 5 symbols!')

    def testAllConstraints() {
        def list = new UsersRepo().getCollection();
        list.each(checkPassportLength);
        list.each(checkLicenceNumber);

        //or
        def allChecks = { checkPassportLength(it); checkLicenceNumber(it) };
        list.each { allChecks };
    }
}