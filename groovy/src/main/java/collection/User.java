package collection;

/**
 * Created by IntelliJ IDEA.
 * collection.User: alexey
 * Date: 15.06.14
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String passportId;
    private String lisenceNumber;
    private Integer phoneNumber;

    public User(String passportId) {
        this.passportId = passportId;
    }

    public User(String passportId, Integer phoneNumber) {
        this.passportId = passportId;
        this.phoneNumber = phoneNumber;
    }

    public User(String passportId, String lisenceNumber, Integer phoneNumber) {
        this.passportId = passportId;
        this.lisenceNumber = lisenceNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getPassportId() {
        return passportId;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }
}
