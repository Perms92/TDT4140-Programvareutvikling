package RooMe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Database;

public class RoomCriteria{

	static ArrayList<RoomCriteria> list = new ArrayList<RoomCriteria>();
	
	public String PersonName;
	public String subject;
	private int capacity;
	private boolean projector;
	private boolean blackboard;
	private boolean hearingaid;
	private int hours;

	public ArrayList<Room> possibleRooms = new ArrayList<Room>();

	public RoomCriteria(String PersonName, String subject, int capacity, boolean projector, boolean blackboard, boolean whiteboard, int hours) {
		setPersonName(PersonName);
		setSubject(subject);
		setCapacity(capacity);
		setProjector(projector);
		setBlackboard(blackboard);
		setHearingaid(whiteboard);
		setHours(hours);

	}
	
	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public static void addRoomCriteria(String personName, String subject, int capacity, boolean projector, boolean blackboard, boolean whiteboard, int hours) throws SQLException{
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.Criterias\n"
				+ "VALUES(?,?,?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		statement.setString(1, personName);
		statement.setString(2, subject);
		statement.setInt(3, capacity);
		statement.setBoolean(4, projector);
		statement.setBoolean(5, blackboard);
		statement.setBoolean(6, whiteboard);
		statement.setInt(6, hours);
		statement.executeUpdate();
		Database.disconnect();
	}
	
	public static void getRoomCriterias() {
		Database.connect();
		try {
			Database.rs = Database.sment.executeQuery("select * from thblaauw_tdt4145database.Criterias");
			System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s %-2s","Foreleser", "Subject", "Capacity", "Projector", "Blackboard", "Whiteboard", "Hours"+"\n");
			System.out.println("---------------------------------------------------------------------------------------------");
			while (Database.rs.next()){
				System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s %-2s"
						+ "", Database.rs.getString(1),
									Database.rs.getString(2),
									Database.rs.getInt(3),
									Database.rs.getBoolean(4),
									Database.rs.getBoolean(5),
									Database.rs.getBoolean(6),
									Database.rs.getInt(7));
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.disconnect(); 
	}
	
	public static ArrayList<RoomCriteria> listOfCriterion() throws SQLException{
		//ArrayList<RoomCriteria> list = new ArrayList<RoomCriteria>();
		String sql = "select * from thblaauw_tdt4145database.Criterias";
		Database.connect();
			try {
				Database.rs = Database.sment.executeQuery(sql);
				while (Database.rs.next()){
					RoomCriteria aCrit = 
					new RoomCriteria(Database.rs.getString(1), Database.rs.getString(2), Database.rs.getInt(3), 
							Database.rs.getBoolean(4), Database.rs.getBoolean(5), Database.rs.getBoolean(6), Database.rs.getInt(7));
					list.add(aCrit);
					} 
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}
		
	public void removeBookedHours() {
		setHours(getHours()-2);
	}

	
	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean isBlackboard() {
		return blackboard;
	}

	public void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}

	public ArrayList<Room> getPossibleRooms() {
		return possibleRooms;
	}

	public void setPossibleRooms(ArrayList<Room> possibleRooms) {
		this.possibleRooms = possibleRooms;
	}

	public boolean isHearingaid() {
		return hearingaid;
	}
	
	public void setHearingaid(boolean whiteboard) {
		this.hearingaid = whiteboard;
	}

	
	
	public String toString() {
		String PersonName = getPersonName();
		String subject = getSubject();
		String capacity = Integer.toString(getCapacity()) + "	";
		String textprojector = "No	";
		String textblackboard = "No	";
		String textwhiteboard = "No	";
		if (isProjector()) {
			textprojector = "Yes";
		}
		if (isBlackboard()) {
			textblackboard = "Yes";
		}
		if (isHearingaid()) {
			textwhiteboard = "Yes";
		}
		System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s %-2s"
				+ "", PersonName, subject, capacity, textprojector, textblackboard, textwhiteboard, String.valueOf(hours)+"\n");
		return (""); 
	}
	
	public static void printList(ArrayList<RoomCriteria> testList) {
		System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s %-5s","Foreleser", "Subject", "Capacity", "Projector", "Blackboard", "Whiteboard", "Hours"+"\n");
		System.out.println("---------------------------------------------------------------------------------------------");
		testList.toString();
	}


	public static void main(String[] args) throws SQLException {
		
	}
	
}
