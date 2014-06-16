package paramCheck;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * (c) Swissquote 6/16/14
 *
 * @author oburov
 */
public class JavaTestDataLoader {



	@Test
	public void testLoad() {
		int index = 1232;
		String name = "Client";
		Address address = new Address();
		address.setIndex(index);
		address.setStreet("Street1");
		Client client = new Client();
		client.setFirstName("Bob");
		client.setFirstName("Dylan");
		DataLoader dataLoader = new DataLoader();
		// introduce mocks
		AddressLoader addressLoader = mock(AddressLoader.class);
		ClientLoader clientLoader = mock(ClientLoader.class);
		when(addressLoader.loadByIndex(index)).thenReturn(address);
		when(clientLoader.loadByName(name)).thenReturn(client);


		dataLoader.setAddressLoader(addressLoader);
		dataLoader.setClientLoader(clientLoader);
		// Test
		Data data = dataLoader.load(name, index);

		assertEquals(address, data.getAddress());
		assertEquals(client, data.getClient());
		verify(addressLoader).loadByIndex(index);
		verify(clientLoader).loadByName(name);
	}
}
