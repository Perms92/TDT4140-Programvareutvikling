package testing;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Database.Database;
import RooMe.Person;
import RooMe.Room;
import RooMe.RoomCriteria;
import RooMe.Timetable;

public class DatabaseTest {

	static Person TestPerson;
	static ArrayList<Timetable> personTablesCreated = new ArrayList<Timetable>();
	ArrayList<Timetable> roomTablesCreated = new ArrayList<Timetable>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Database.connect();
		
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
	public void testDatabase_addAndDeletePerson() throws SQLException {
		TestPerson = new Person("Test Man", true);
		//check if timetable for all days was created and person is in database
			personTablesCreated = Timetable.getPersonTimeTable(TestPerson.getName());
			assertEquals(5,personTablesCreated.size());
			assertEquals(TestPerson.getName(), Person.getPerson("Test Man"));
		Person.deletePerson(TestPerson.getName());
		//check if person is deleted
		personTablesCreated = Timetable.getPersonTimeTable(TestPerson.getName());
		assertEquals(0,personTablesCreated.size());
		assertEquals(null, Person.getPerson("Test Man"));
			
		
	}
	
	@Test
	public void testDatabase_addAndDeleteRoom() throws SQLException {
		Room testRoom = new Room(true, "T0", 21, false, false, false);
		//check if timetable for all days was created and person is in database
			roomTablesCreated = Timetable.getRoomTimeTable(testRoom.getName());
			assertEquals(5,roomTablesCreated.size());
			assertEquals(testRoom.getName(), Room.getRoom("T0"));
		Room.deleteRoom(testRoom.getName());
		//check if person is deleted
		roomTablesCreated = Timetable.getRoomTimeTable(testRoom.getName());
		assertEquals(0,roomTablesCreated.size());
		assertEquals(null, Room.getRoom("Test Man"));
	}
	
	@Test
	public void testDatabase_addAndDeleteRoomCriteria() throws SQLException {
		RoomCriteria TestCrit = new RoomCriteria("Test Crit", "Test subject", 20, false, false, false, 2);
		RoomCriteria.addRoomCriteria(TestCrit.getPersonName(), TestCrit.getSubject(), TestCrit.getCapacity(), TestCrit.isProjector(), TestCrit.isBlackboard(), TestCrit.isHearingaid(), TestCrit.getHours());
		//check if timetable for all days was created and person is in database
		//Should NOT be created in this scenario
			personTablesCreated = Timetable.getPersonTimeTable(TestCrit.getPersonName());
			assertEquals(0,personTablesCreated.size());
			assertEquals(TestCrit.getPersonName(), RoomCriteria.getPersonOfRoomCriteria("Test Crit"));
		//This test should be expanded to delete based on key values and check all values of the criteria, but not top priority with deadline coming
		RoomCriteria.deleteRoomCriteria(TestCrit.getPersonName());
		//check if person is deleted
		assertEquals(null, Person.getPerson("Test Man"));
	}
	

}
