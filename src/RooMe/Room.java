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
	
	public Room(boolean update, String name, int capacity, boolean projector, boolean blackboard, boolean whiteboard) throws SQLException {
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
	
	//Just a validation-method
		public static String getRoom(String name) throws SQLException {
			String sql = "SELECT * FROM thblaauw_tdt4145database.Room\n"
					+ "WHERE Room.Name = '" +name+ "'";
			Database.rs = Database.sment.executeQuery(sql);
			if (Database.rs.next()) {
				return Database.rs.getString(1);
			}
			return null;
			
		}
		
	public static void deleteRoom(String name) throws SQLException {
			String sql = "DELETE FROM thblaauw_tdt4145database.Room\n"
					+ "WHERE Room.Name = '" +name+ "'";
			String sql2 = "DELETE FROM thblaauw_tdt4145database.TimeTable\n"
					+ "WHERE TimeTable.Room = '" +name+ "'";
			Database.sment.executeUpdate(sql);
			Database.sment.executeUpdate(sql2);
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
		String sql = "INSERT INTO thblaauw_tdt4145database.Room\n"
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setInt(2, capacity);
		statement.setBoolean(3, projector);
		statement.setBoolean(4, blackboard);
		statement.setBoolean(5, whiteboard);
		statement.executeUpdate();
	}
	
	/* public static void printRooms() {
	TRENGER VI DENNE?
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
	}*/
		
	public static void main(String[] args) throws SQLException {
		//addRoom("R11", 51, true, true, true);
		//addRoom("R12", 69, true, false, false);
		//deleteRoom("R1");
		}

	
	@Override
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

}
