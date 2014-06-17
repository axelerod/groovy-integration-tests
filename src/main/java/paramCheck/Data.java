package paramCheck;

/**
 * (c) Swissquote 6/10/14
 *
 * @author oburov
 */
public class Data {
	private Client client;
	private Address address;

	public Data(Client client, Address address) {
		this.client = client;
		this.address = address;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
