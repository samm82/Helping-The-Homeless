/**
 * 
 */
package adt;

import io.*;
import adt.ShelterT.shelterResT;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author joshua
 *
 */
public class ShelterTTest {

	ShelterT[][] shelters;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		shelters = Read.readShelterData();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for size of Shelters to ensure it was read in properly
	 */
	@Test
	public void testSize() {
		assert(shelters.length == 5);
		assert(shelters[0].length == 40);
	}
	
	/**
	 * Test method for {@link adt.ShelterT#getType()}.
	 */
	@Test
	public void testGetType() {
		assert(shelters[0][0].getType() == shelterResT.MALE);
	}

	/**
	 * Test method for {@link adt.ShelterT#getOrgName()}.
	 */
	@Test
	public void testGetOrgName() {
		assert(shelters[0][0].getOrgName().equals("Christie Ossington Neighbourhood Centre"));
	}

	/**
	 * Test method for {@link adt.ShelterT#getCap2018(int)}.
	 */
	@Test
	public void testGetCap2018() {
		assert(shelters[0][0].getCap2018(5) == 17);
	}

}
