package RooMe;

import java.sql.*;
import java.util.ArrayList;

import Database.Database;

public class Room{

	private int capacity;
	private boolean projector;
	private boolean blackboard;
	private boolean whiteboard;
	private String name;
	private ArrayList<Timetable> timeTables = new ArrayList<Timetable>();
//	private int roomID;
	
	protected Room(boolean update, String name, int capacity, boolean projector, boolean blackboard, boolean whiteboard) throws SQLException {
		setName(name);
		setCapacity(capacity);
		setProjector(projector);
		setBlackboard(blackboard);
		setWhiteboard(whiteboard);
			if (update) {
			addRoom(name, capacity, projector, blackboard, whiteboard);
				for (int day = 1; day<6;  day++) {
					Timetable oneDay = new Timetable(null, name, day);
					oneDay.addTimetable();
					timeTables.add(oneDay);
				}
			}
	}
	
	public ArrayList<Timetable> getTimeTables() {
		return timeTables;
	}

	public void setTimeTables(ArrayList<Timetable> timeTables) {
		this.timeTables = timeTables;
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

	public boolean isWhiteboard() {
		return whiteboard;
	}

	public void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}





	public static void addRoom(String name, int capacity, boolean projector, boolean blackboard, boolean whiteboard) throws SQLException{
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.Room\n"
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setInt(2, capacity);
		statement.setBoolean(3, projector);
		statement.setBoolean(4, blackboard);
		statement.setBoolean(5, whiteboard);
		statement.executeUpdate();
		Database.disconnect();
	}
	
	public static void printRooms() {
		Database.connect();
		try {
			Database.rs = Database.sment.executeQuery("select * from thblaauw_tdt4145database.Room");
			System.out.println("Room         Capacity     Projector       Blackboard     Whiteboard");
			System.out.println("-------------------------------------------------------------------");
			while (Database.rs.next()){
				System.out.println(	Database.rs.getString(1)	+"           "+
									Database.rs.getInt(2)		+"           "+
									Database.rs.getBoolean(3)	+"           "+
									Database.rs.getBoolean(4)	+"           "+
									Database.rs.getBoolean(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.disconnect();
	}
	
	public static void deleteRoom(String name) throws SQLException {

		Database.connect();
	//Lag metoden slik at du ikke kan lage to rom med samme navn, uavhengig av caps (R1 og r1 går ikke).

	// SKAL IKKE VÆRE MULIG Å GI NULL SOM NAVN LENGER
	 if (name == "null") {
		try {
	
			Database.sment.executeUpdate("DELETE FROM thblaauw_tdt4145database.Room"
					+ " WHERE Room.Name ='" + name + "'");
			System.out.println("The room with name: "+name+" is deleted from the database.\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Database.disconnect();
	 	}
	 }

	
		
	public static void main(String[] args) throws SQLException {
		//addRoom("R9", 71, true, false, true);
		//addRoom("R10", 71, true, false, true);
		//deleteRoom("R1");
		printRooms();
		}
	
	public String toString() {
		String name = this.name;
		String capacity = Integer.toString(this.capacity) + "	";
		String textprojector = "No	";
		String textblackboard = "No	";
		String textwhiteboard = "No	";
		if (projector == true) {
			textprojector = "Yes";
		}
		if (blackboard == true) {
			textblackboard = "Yes";
		}
		if (whiteboard == true) {
			textwhiteboard = "Yes";
		}
		return  name + " 	|	 " + capacity + " 	|	 " + textprojector + " 	|	 " + textblackboard + " 	|	 " + textwhiteboard; 
	}

/*
	@Override
	public String toString() {
		return name + " has room for " + space + " persons, " + toEnglish(projector) + " projector, " 
		+ toEnglish(blackboard) + " blackboard, " + toEnglish(whiteboard) + " whiteboard.\n" + expSentence() +".";
	}
*/	
	
	
	/*
	public static void main(String[] args) {
		Room test = new Room("Test1", 100, true, false, true);
		System.out.println(test.isProjector());
		System.out.println(test);
		System.out.println(test.roomID);
		System.out.println(test.getRoomID());
	}
*/

}

