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
import RooMe.AssignRooms;
import RooMe.Person;
import RooMe.Room;
import RooMe.RoomCriteria;
import RooMe.SearchForRoomDB;
import RooMe.Timetable;

public class AllTests {


	static AssignRooms testAssign;
	static ArrayList<Timetable> roomTablesCreated = new ArrayList<Timetable>();
	static ArrayList<Timetable> personTablesCreated = new ArrayList<Timetable>();
	static Person TestPerson;
	static SearchForRoomDB testSearch;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Database.connect();
		Timetable.resetTimeTables();
		testAssign = new AssignRooms();
		testAssign.AssignAllRooms();
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
		personTablesCreated.clear();
		roomTablesCreated.clear();
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
	public void testAssignRooms_noRoomsMissing() {
		//Simple test, whole constructor bases on a while loop where this condition must be false
		//must write a lot more
		assertTrue(testAssign.noRooms.isEmpty());
	}
	
	@Test
	public void testTimetable_allHoursBooked() throws SQLException {
		ArrayList<Timetable> kristiansTables =  Timetable.getPersonTimeTable("Kristian");
		ArrayList<RoomCriteria> allCriteria = RoomCriteria.listOfCriterion();
		int inloop = 0;
		int hoursFromCrit = 0;
		int bookedHours = 0;
		for (RoomCriteria crit : allCriteria) {
			System.out.println(crit.getPersonName());
			if ((crit.getPersonName()).equals("Kristian")){
				hoursFromCrit += crit.getHours();
				inloop++;
			}
		}
		for (Timetable table : kristiansTables) {
			bookedHours += table.countBookedHours();
		}
		assertEquals(5, inloop);
		assertEquals(10, hoursFromCrit);
		assertEquals(hoursFromCrit, bookedHours);
	}
	
	@Test
	public void testTimetable_RightRoomBooked() throws SQLException{
		ArrayList<Timetable> AndréTables = Timetable.getPersonTimeTable("André Blaauw");
		ArrayList<RoomCriteria> allCriteria = RoomCriteria.listOfCriterion();
		String subject = "";
		for (RoomCriteria crit : allCriteria) {
			if ((crit.getPersonName()).equals("André Blaauw")){
				subject = crit.getSubject();
				break;
			}
		
		}
		String RoomBookedMon8 = AndréTables.get(0).getEight();
		ArrayList<Timetable> AndrésRoomTable =  Timetable.getRoomTimeTable(RoomBookedMon8);
		String subjectForAndréMon8 = AndrésRoomTable.get(0).getEight();
		
		assertEquals(subject, subjectForAndréMon8);
	}
	
	@Test
	public void testSearchForRoomDB_CheckFindOnlyRoom() {
		//should only find 1 room in our pre-defined database
		assertEquals(1, testSearch.getAcceptedRooms().size());
		assertEquals("R1000", testSearch.getAcceptedRooms().get(0).getName());
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
	
	@Test
	public void testTimetable_canUpdateWithStartAndEndtime() throws SQLException {
		//I know that the person and room is unused in our pre-defined database
		Timetable.updatePersonTable("Kristian fem", "R7", 3, 10, 14);
		Timetable.updateRoomTable("R7", "Femfag", 3, 10, 14);
		personTablesCreated = Timetable.getPersonTimeTable("Kristian fem");
		roomTablesCreated = Timetable.getRoomTimeTable("R7");
		//check if only this period was booked for person
		assertEquals(null, personTablesCreated.get(2).getNine());
		assertEquals( "R7", personTablesCreated.get(2).getTen());
		assertEquals("R7", personTablesCreated.get(2).getEleven());
		assertEquals("R7",personTablesCreated.get(2).getTwelve());
		assertEquals("R7",personTablesCreated.get(2).getThirteen());
		assertEquals(null,personTablesCreated.get(2).getFourteen());
		
		//check if only this period was booked for room
		assertEquals(null, roomTablesCreated.get(2).getNine());
		assertEquals("Femfag", roomTablesCreated.get(2).getTen());
		assertEquals("Femfag", roomTablesCreated.get(2).getEleven());
		assertEquals("Femfag", roomTablesCreated.get(2).getTwelve());
		assertEquals("Femfag", roomTablesCreated.get(2).getThirteen());
		assertEquals(null, roomTablesCreated.get(2).getFourteen());
		//To check manually, should be included in coverage
		System.out.println(personTablesCreated);
		System.out.println(roomTablesCreated);
	}
	



}
