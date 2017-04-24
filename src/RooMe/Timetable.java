package RooMe;
import java.sql.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

import Database.Database;


public class Timetable {

	public String personOwner;
	public String roomOwner;
	//timetable has only one owner
	public String personInRoom;
	public String subject; 
	public int day, week, year;
	public String eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen;
	
	
	
	public Timetable(String personOwner, String roomOwner, int day) { 
		setpersonOwner(personOwner);
		setroomOwner(roomOwner);
		setDay(day);
		checkSingularity();
	}
	
	
	public int countBookedHours() {
		int count = 0;
		if ((eight != null)) {
			count++;
		}
		if ((nine != null)) {
			count++;
		}
		if ((ten != null)) {
			count++;
		}
		if ((eleven != null)) {
			count++;
		}
		if ((twelve != null)) {
			count++;
		}
		if ((thirteen != null)) {
			count++;
		}
		if ((fourteen != null)) {
			count++;
		}
		if ((fifteen != null)) {
			count++;
		}
		return count;
	}
	
	public static ArrayList<Timetable> getPersonTimeTable(String personOwner) throws SQLException {
		ArrayList<Timetable> personTableAllDays = new ArrayList<Timetable>();
		String sql = "select * from thblaauw_tdt4145database.TimeTable "
				+ "WHERE TimeTable.Person = '" + personOwner +"'";
			Database.rs = Database.sment.executeQuery(sql);
			while (Database.rs.next()){
				Timetable personTable = new Timetable(Database.rs.getString(2), null, Database.rs.getInt(3));
				personTable.setEight(Database.rs.getString(4));
				personTable.setNine(Database.rs.getString(5));
				personTable.setTen(Database.rs.getString(6));
				personTable.setEleven(Database.rs.getString(7));
				personTable.setTwelve(Database.rs.getString(8));
				personTable.setThirteen(Database.rs.getString(9));
				personTable.setFourteen(Database.rs.getString(10));
				personTable.setFifteen(Database.rs.getString(11));
				personTableAllDays.add(personTable);
			}
		return personTableAllDays;
		
	}
	
	public static ArrayList<Timetable> getRoomTimeTable(String roomOwner) throws SQLException {
		ArrayList<Timetable> roomTableAllDays = new ArrayList<Timetable>();
		String sql = "select * from thblaauw_tdt4145database.TimeTable "
				+ "WHERE TimeTable.Room = '" + roomOwner +"'";
			Database.rs = Database.sment.executeQuery(sql);
			while (Database.rs.next()){
				Timetable roomTable = new Timetable(null, Database.rs.getString(1), Database.rs.getInt(3));
				roomTable.setEight(Database.rs.getString(4));
				roomTable.setNine(Database.rs.getString(5));
				roomTable.setTen(Database.rs.getString(6));
				roomTable.setEleven(Database.rs.getString(7));
				roomTable.setTwelve(Database.rs.getString(8));
				roomTable.setThirteen(Database.rs.getString(9));
				roomTable.setFourteen(Database.rs.getString(10));
				roomTable.setFifteen(Database.rs.getString(11));
				roomTableAllDays.add(roomTable);
			}
		return roomTableAllDays;
	}

	private void setroomOwner(String roomOwner) {
		this.roomOwner = roomOwner;
	}
	private void setpersonOwner(String personOwner) {
		this.personOwner = personOwner;
		
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

	public String getroomOwner() {
		return roomOwner;
	}
	public String getpersonOwner() {
		return personOwner;
	}
	
	


	public void checkSingularity() throws IllegalStateException {
		if (personOwner!=null && roomOwner!=null)
			throw new IllegalStateException("The timetable is either for a Person or a Room, not both or neither!");
	}
	
	public void addTimetable() throws SQLException {
		String sql = "INSERT INTO thblaauw_tdt4145database.TimeTable\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		if (getpersonOwner() == null) {
			statement.setString(1, getroomOwner());
			statement.setString(2, "null"); 	
		}
		else {
			statement.setString(2, getpersonOwner());	
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
	}
	
	//FLYTTES?
	public static void updateRoomTable(String roomOwner, String subject, int day, int startTime, int endTime) throws SQLException {
		//Subject can at most be 7 characters long
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
		sql.append("`" + (endTime-1) + "` = '" + subject + "'\n" + "WHERE Room = '" + roomOwner +"' AND Day = " + day);
		Database.sment.executeUpdate(sql.toString());
	}
	
	public static void resetTimeTables() throws SQLException {
		//Subject can at most be 7 characters long
		Database.sment.executeUpdate(
		"UPDATE thblaauw_tdt4145database.TimeTable "
		+ "SET `8` = null, `9` = null, `10` = null, `11` = null, `12` = null, `13` = null, `14` = null, `15` = null");
	}
	
	//FLYTTES?
	public static void updatePersonTable(String personOwner, String roomOwner, int day, int startTime, int endTime) throws SQLException {
		int bookingDuration = endTime - startTime;
		int count = 1; 
		StringBuilder sql = new StringBuilder(
				"UPDATE thblaauw_tdt4145database.TimeTable\n"
			+ 	"SET `" + startTime + "` = '" + roomOwner + "', ");
		while (count < bookingDuration-1) {
			int nextHr = startTime+count;
			sql.append("`" + nextHr + "` = '" + roomOwner + "', ");
			count ++;
		}
		sql.append("`" + (endTime-1) + "` = '" + roomOwner + "'\n" + "WHERE Person = '" + personOwner +"' AND Day = " + day);
		Database.sment.executeUpdate(sql.toString());
	}
		
	
	
	//FLYTTES?
	public static void bookClassforSemester(String personOwner, String roomOwner, String subject, int day, int startTime, int endTime) throws SQLException {
		updatePersonTable(personOwner, roomOwner, day, startTime, endTime);
		updateRoomTable(roomOwner, subject, day, startTime, endTime);
	}
		
	
	public String toString() {
		if (roomOwner == null) {
			return String.format("%-3s %-20s %-5s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s", "   ", getpersonOwner(), getDay(), getEight(), getNine(), getTen(), getEleven(), getTwelve(), getThirteen(), getFourteen(), getFifteen()+ "\n");
		}
		else {
		return String.format("%-3s %-20s %-5s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s", "   ", getroomOwner(), getDay(), getEight(), getNine(), getTen(), getEleven(), getTwelve(), getThirteen(), getFourteen(), getFifteen()+ "\n");
		}
	}
	
	/* NEED THIS?public static void printTableArray(ArrayList<Timetable> tableList, boolean headline){
		if (headline == true) {
		System.out.printf("%-3s %-20s %-5s %-7s %-7s %-7s %-7s %-7s %-7s %-7s %-7s", "   ","Room/Person", "Day", "8", "9", "10", "11", "12", "13", "14", "15"+"\n");
		System.out.println("-------------------------------------------------------------------------------------------------");
		}
		for (Timetable table : tableList) {
			System.out.println(table);
		}
	}*/
	
	public static void main(String[] args) throws SQLException {
	}

}
