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
    private String licenceNumber;
    private Integer phoneNumber;

	// ... and other 30 fields

    public User(String passportId) {
        this.passportId = passportId;
    }

	public User(String passportId, String licenceNumber) {
		this.passportId = passportId;
		this.licenceNumber = licenceNumber;
	}

	public User(String passportId, String licenceNumber, Integer phoneNumber) {
        this.passportId = passportId;
        this.licenceNumber = licenceNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getPassportId() {
        return passportId;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
}
