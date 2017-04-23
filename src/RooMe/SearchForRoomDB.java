package RooMe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.Database;

public class SearchForRoomDB {
	//public for now while testing GUI
	public static ArrayList<Room> acceptedRooms = new ArrayList<Room>();
	
	public ArrayList<Room> getAcceptedRooms() {
		return acceptedRooms;
	}

	//Let user know that we did a search without some of its criteria because no room matched them all
	public boolean error;
	public String errorMessage;
	
	public SearchForRoomDB(int capacity, boolean projector, boolean blackboard, boolean whiteboard) throws SQLException {
		acceptedRooms = findMatches(capacity, projector, blackboard, whiteboard);
	}
	
	
	
	

	
	public ArrayList<Room> 
	findMatches(int capacity, boolean projector, boolean blackboard, boolean whiteboard)
	throws SQLException{
		acceptedRooms = new ArrayList<Room>();
		String sql = "select * from thblaauw_tdt4145database.Room "
				+ "WHERE Room.Capacity >= " + capacity + " AND "
				+ "(Room.Projector = true OR Room.Projector = " + projector + ") AND "
				+ "(Room.blackboard = true OR Room.blackboard = " + blackboard + ") AND "
				+ "(Room.Whiteboard = true OR Room.whiteboard = " + whiteboard + ")";
		Database.connect();
			try {
				Database.rs = Database.sment.executeQuery(sql);
				while (Database.rs.next()){
					Room roomMatch = 
					new Room(false, Database.rs.getString(1), Database.rs.getInt(2),Database.rs.getBoolean(3),Database.rs.getBoolean(4), Database.rs.getBoolean(5));
					acceptedRooms.add(roomMatch); 
					} 
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return acceptedRooms;
	}
		
	
	public String toString() {
		if (acceptedRooms.size() > 0) {
			for (Room room : acceptedRooms) {
				System.out.println(room);
			}
			return "end of list";
		}
		else {
			return "no rooms found";
		}
	}
	
	public static void main(String[] args) throws SQLException {
		SearchForRoomDB testSok = new SearchForRoomDB(100, true, false, true);
		System.out.println(testSok);
	}

	
}
