package paramCheck;

import java.util.Date;

/**
 * (c) Swissquote 6/10/14
 *
 * @author oburov
 */
public class Client {
	private String firstName;
	private String lastName;
	private Date dob;

	// getters and setters...

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
