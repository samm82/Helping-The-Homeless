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
 * @author Joshua
 *
 */
public class CoolingCentreTTest {

	CoolingCentreT[] cooling_centres;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cooling_centres	= Read.readCoolingData();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests data size
	 */
	@Test
	public void testReadCoolingCentres() {
		assert(cooling_centres.length == 172);
	}
	
	/**
	 * Test method for {@link adt.CoolingCentreT#toString()}.
	 */
	@Test
	public void testToString() {
		assert(cooling_centres[0].toString().equals("Agincourt Library | 155 Bonis Ave"));
	}

}
