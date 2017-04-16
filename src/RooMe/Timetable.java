package RooMe;
import java.sql.*;
import java.lang.StringBuilder;

import Database.Database;


public class Timetable {

	public Person Person;
	public Room Room;
	public int day, week, year;
	public boolean eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
	
	
	
	public Timetable(Person person, Room room, int day) { 
		setPerson(person);
		setRoom(room);
		setDay(day);
		checkSingularity();
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public boolean isEight() {
		return eight;
	}
	public void setEight(boolean eight) {
		this.eight = eight;
	}
	public boolean isNine() {
		return nine;
	}
	public void setNine(boolean nine) {
		this.nine = nine;
	}
	public boolean isTen() {
		return ten;
	}
	public void setTen(boolean ten) {
		this.ten = ten;
	}
	public boolean isEleven() {
		return eleven;
	}
	public void setEleven(boolean eleven) {
		this.eleven = eleven;
	}
	public boolean isTwelve() {
		return twelve;
	}
	public void setTwelve(boolean twelve) {
		this.twelve = twelve;
	}
	public boolean isThirteen() {
		return thirteen;
	}
	public void setThirteen(boolean thirteen) {
		this.thirteen = thirteen;
	}
	public boolean isFourteen() {
		return fourteen;
	}
	public void setFourteen(boolean fourteen) {
		this.fourteen = fourteen;
	}
	public boolean isFifteen() {
		return fifteen;
	}
	public void setFifteen(boolean fifteen) {
		this.fifteen = fifteen;
	}
	public boolean isSixteen() {
		return sixteen;
	}
	public void setSixteen(boolean sixteen) {
		this.sixteen = sixteen;
	}


	public Room getRoom() {
		return Room;
	}
	public void setRoom(Room Room) {
		this.Room = Room;
	}
	public Person getPerson() {
		return Person;
	}
	public void setPerson(Person Person) {
		this.Person = Person;
	}
	


	public void checkSingularity() throws IllegalStateException {
		if (Person!=null && Room!=null)
			throw new IllegalStateException("The timetable is either for a Person or a Room, not both!");
	}
	
	public void addTimetable() throws SQLException {
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.TimeTable\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		if (getPerson() == null) {
			statement.setString(1, getRoom().getName());
			statement.setString(2, "null"); 	
		}
		else {
			statement.setString(2, getPerson().getName());	
			statement.setString(1, "null");
		}		
		statement.setInt(3, getDay());
		statement.setBoolean(4, isEight());
		statement.setBoolean(5, isNine());
		statement.setBoolean(6, isTen());
		statement.setBoolean(7, isEleven());
		statement.setBoolean(8, isTwelve());
		statement.setBoolean(9, isThirteen());
		statement.setBoolean(10, isFourteen());
		statement.setBoolean(11, isFifteen());
		statement.executeUpdate();
		Database.disconnect();
	}
		
	public void updateRoomTable(Room room, int day, int startTime, int endTime) {
		int bookingDuration = endTime - startTime;
		int count = 1; 
		StringBuilder sql = new StringBuilder(
				"UPDATE thblaauw_tdt4145database.TimeTable\n"
			+ 	"SET " + startTime + " = true, ");
		while (count < bookingDuration) {
			int nextHr = startTime+count;
			sql.append(nextHr + " = true, ");
			count ++;
		}
		sql.append("\n" + "WHERE Room = '" + room.getName() +"' AND Day = " + day);
		System.out.println(sql);
	}
	
	public void updatePersonTable(Person Person, int day, int startTime, int endTime) {
		
	}
	
	
	
	public void bookClassforSemester(Person person, Room room, int day, int startTime, int endTime) throws SQLException {
		//if they doesn't exist?
		Timetable yourBasicTable = new Timetable(person, null, day);
		Timetable RoomsWeeklyTable = new Timetable(null, room, day);
		yourBasicTable.addTimetable();
		RoomsWeeklyTable.addTimetable();
		
		//updateRoomTable();
	}
	
	
	
	
	public static void main(String[] args) throws SQLException {
		Timetable testTable = new Timetable(null, null, 1); 
		testTable.updateRoomTable(new Room("what", 50, false, false, false), 1, 9, 14);
	}

}
