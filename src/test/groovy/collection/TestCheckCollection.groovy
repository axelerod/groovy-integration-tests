package collection

class TestCheckCollection extends  GroovyTestCase{
    void test() {
        def list = new UsersRepo().getCollection();
        def checkPassportLength = {assert it.passportId.length() > 2 :
                "PassportId should be more then 2 symbols"};
        list.each(checkPassportLength);
    }
}