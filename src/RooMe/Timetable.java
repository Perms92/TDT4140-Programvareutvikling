package RooMe;
import java.sql.*;
import java.lang.StringBuilder;

import Database.Database;


public class Timetable {

	public String personName;
	public String roomName;
	public int day, week, year;
	public String eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
	
	
	
	public Timetable(String personName, String roomName, int day) { 
		setPersonName(personName);
		setRoomName(roomName);
		setDay(day);
		checkSingularity();
	}


	private void setRoomName(String roomName) {
		this.roomName = roomName;
	}


	private void setPersonName(String personName) {
		this.personName = personName;
		
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
	

	public String getEight() {
		return eight;
	}
	public void setEight(String eight) {
		this.eight = eight;
	}
	public String getNine() {
		return nine;
	}
	public void setNine(String nine) {
		this.nine = nine;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEleven() {
		return eleven;
	}
	public void setEleven(String eleven) {
		this.eleven = eleven;
	}
	public String getTwelve() {
		return twelve;
	}
	public void setTwelve(String twelve) {
		this.twelve = twelve;
	}
	public String getThirteen() {
		return thirteen;
	}
	public void setThirteen(String thirteen) {
		this.thirteen = thirteen;
	}
	public String getFourteen() {
		return fourteen;
	}
	public void setFourteen(String fourteen) {
		this.fourteen = fourteen;
	}
	public String getFifteen() {
		return fifteen;
	}
	public void setFifteen(String fifteen) {
		this.fifteen = fifteen;
	}
	public String getSixteen() {
		return sixteen;
	}
	public void setSixteen(String sixteen) {
		this.sixteen = sixteen;
	}


	public String getRoomName() {
		return roomName;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	


	public void checkSingularity() throws IllegalStateException {
		if (personName!=null && roomName!=null)
			throw new IllegalStateException("The timetable is either for a Person or a Room, not both or neither!");
	}
	
	public void addTimetable() throws SQLException {
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.TimeTable\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		if (getPersonName() == null) {
			statement.setString(1, getRoomName());
			statement.setString(2, "null"); 	
		}
		else {
			statement.setString(2, getPersonName());	
			statement.setString(1, "null");
		}		
		statement.setInt(3, getDay());
		statement.setString(4, getEight());
		statement.setString(5, getNine());
		statement.setString(6, getTen());
		statement.setString(7, getEleven());
		statement.setString(8, getTwelve());
		statement.setString(9, getThirteen());
		statement.setString(10, getFourteen());
		statement.setString(11, getFifteen());
		statement.executeUpdate();
		Database.disconnect();
	}
	
	//FLYTTES?
	public static void updateRoomTable(String roomName, String subject, int day, int startTime, int endTime) throws SQLException {
		//Subject can at most be 7 characters long
		Database.connect();
		int bookingDuration = endTime - startTime;
		int count = 1; 
		StringBuilder sql = new StringBuilder(
				"UPDATE thblaauw_tdt4145database.TimeTable\n"
			+ 	"SET `" + startTime + "` = '" + subject + "', ");
		while (count < bookingDuration-1) {
			int nextHr = startTime+count;
			sql.append("`" + nextHr + "` = '" + subject + "', ");
			count ++;
		}
		sql.append("`" + (endTime-1) + "` = '" + subject + "'\n" + "WHERE Room = '" + roomName +"' AND Day = " + day);
		Database.sment.executeUpdate(sql.toString());
		Database.disconnect();
	}
	
	//FLYTTES?
	public static void updatePersonTable(String personName, String roomName, int day, int startTime, int endTime) throws SQLException {
		Database.connect();
		int bookingDuration = endTime - startTime;
		int count = 1; 
		StringBuilder sql = new StringBuilder(
				"UPDATE thblaauw_tdt4145database.TimeTable\n"
			+ 	"SET `" + startTime + "` = '" + roomName + "', ");
		while (count < bookingDuration-1) {
			int nextHr = startTime+count;
			sql.append("`" + nextHr + "` = '" + roomName + "', ");
			count ++;
		}
		sql.append("`" + (endTime-1) + "` = '" + roomName + "'\n" + "WHERE Person = '" + personName +"' AND Day = " + day);
		Database.sment.executeUpdate(sql.toString());
		Database.disconnect();
	}
		
	
	
	//FLYTTES?
	public static void bookClassforSemester(Person person, Room room, String subject, int day, int startTime, int endTime) throws SQLException {
		updatePersonTable(person.getName(), room.getName(), day, startTime, endTime);
		updateRoomTable(room.getName(), subject, day, startTime, endTime);
	}
		
	
	
	public static void main(String[] args) throws SQLException {
		//Room testRoom = new Room("R100", 50, false, false, false);
		//updatePersonTable(testPerson.getName(), "TDT4100", 1, 8, 14);
		Room testRoom = new Room(true, "R1000", 100, true, true, true);
		Person testPerson = new Person("Slutt for dagen", true);
		bookClassforSemester(testPerson, testRoom, "TDT8008", 3, 9, 11);
	}

}
