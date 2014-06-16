package paramCheck

import org.junit.Test

/**
 * (c) Swissquote 6/10/14
 * @author oburov
 */
class TestParamCheck {
    @Test
    public void testParams() {
        def index = 1232;
        def address = [street: "Street1", index: index] as Address;             //cast to type
        def client = [firstName: "Bob", lastName: "Dylan"] as Client;
        def name = "Client";
        def dataLoader = new DataLoader();
        // introduce mocks
        def addressLoader = [loadByIndex: { assert it == index; address }];     //map [method : closure]
        def clientLoader = { clientName -> assert clientName == name; client }  // simply closure

        dataLoader.setAddressLoader(addressLoader as AddressLoader);            // cast to type
        dataLoader.setClientLoader(clientLoader as ClientLoader);
        // Test
        def load = dataLoader.load(name, index);
        assert load.address == address;
        assert load.client == client;
        assert load.address.street == address.street;
    }
}
