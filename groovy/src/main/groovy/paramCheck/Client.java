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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Client client = (Client) o;

		if (dob != null ? !dob.equals(client.dob) : client.dob != null) return false;
		if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
		if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (dob != null ? dob.hashCode() : 0);
		return result;
	}
}
