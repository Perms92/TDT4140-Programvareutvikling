package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Database.Database;
import RooMe.SearchForRoomDB;

public class SearchForRoomDBTest {
	
	static SearchForRoomDB testSearch;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Database.connect();
		testSearch = new SearchForRoomDB(100, true, false, true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Database.disconnect();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchForRoomDB_CheckFindOnlyRoom() {
		//should only find 1 room in our pre-defined database
		assertEquals(1, testSearch.getAcceptedRooms().size());
		assertEquals("R1000", testSearch.getAcceptedRooms().get(0).getName());
	}
	
	/*public void testSearchForRoomDB_Condition() {
		
	}
	
	public void testSearchForRoomDB_Condition() {
		
	}
	public void testSearchForRoomDB_Condition() {
		
	}
	
	public void testSearchForRoomDB_() {
		
	}
	
	public void testSearchForRoomDB_() {
		
	}
	
	public void testSearchForRoomDB_() {
	
		
	}*/
}
