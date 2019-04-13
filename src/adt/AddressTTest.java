/**
 * 
 */
package adt;
import io.*;
import algsstructs.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author joshua
 *
 */
public class AddressTTest {

	TST<AddressT> addresses;
	AddressT current_address;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		addresses = Read.readAddressData();
		assert(addresses.contains("2459 Islington Ave"));
		current_address = addresses.get("2459 Islington Ave");		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadAddress() {
		assert(addresses.size() == 521826);
	}
	
	/**
	 * Test method for {@link adt.AddressT#getNum()}.
	 */
	@Test
	public void testGetNum() {
		assert(current_address.getNum().equals("2459"));
	}

	/**
	 * Test method for {@link adt.AddressT#getSt()}.
	 */
	@Test
	public void testGetSt() {
		assert(current_address.getSt().equals("Islington Ave"));
	}

	/**
	 * Test method for {@link adt.AddressT#getLat()}.
	 */
	@Test
	public void testGetLat() {
		assert(current_address.getLat() == 43.72705634);
	}

	/**
	 * Test method for {@link adt.AddressT#getLon()}.
	 */
	@Test
	public void testGetLon() {
		assert(current_address.getLon() == -79.56046567);
	}

}
