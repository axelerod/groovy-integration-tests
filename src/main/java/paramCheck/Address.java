package paramCheck;

/**
 * (c) Swissquote 6/10/14
 *
 * @author oburov
 */
public class Address {
	private String street;
	private int index;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		if (index != address.index) return false;
		if (street != null ? !street.equals(address.street) : address.street != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = street != null ? street.hashCode() : 0;
		result = 31 * result + index;
		return result;
	}
}
