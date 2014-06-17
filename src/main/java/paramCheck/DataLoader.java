package paramCheck;

/**
 * (c) Swissquote 6/10/14
 *
 * @author oburov
 */
public class DataLoader {
	private ClientLoader clientLoader;
	private AddressLoader addressLoader;
	public Data load(String name, int index) {
		Client client = clientLoader.loadByName(name);
		Address address = addressLoader.loadByIndex(index);
		return new Data(client, address);
	}

	public void setClientLoader(ClientLoader clientLoader) {
		this.clientLoader = clientLoader;
	}

	public void setAddressLoader(AddressLoader addressLoader) {
		this.addressLoader = addressLoader;
	}
}
