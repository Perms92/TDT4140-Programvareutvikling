package RooMe;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.Database;

public class RoomCriteria extends Room{
	
	public String PersonName;
	public String fag;
	
	protected RoomCriteria(String personName, String fag, String name, int capacity, boolean projector, boolean blackboard, boolean whiteboard) {
		super(name, capacity, projector, blackboard, whiteboard);
		this.PersonName = personName;
		this.fag = fag;
		// TODO Auto-generated constructor stub
	}
	
	public static void addRoomCriteria(String personName, String fag, int capacity, boolean projector, boolean blackboard, boolean whiteboard) throws SQLException{
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.Criterias\n"
				+ "VALUES(?,?,?,?,?,?)";
		PreparedStatement statement = Database.conn.prepareStatement(sql);
		statement.setString(1, personName);
		statement.setString(2, fag);
		statement.setInt(3, capacity);
		statement.setBoolean(4, projector);
		statement.setBoolean(5, blackboard);
		statement.setBoolean(6, whiteboard);
		statement.executeUpdate();
		Database.disconnect();
	}
		
	/*public RoomCriteria(int studentNumbers, boolean projector, boolean blackBoard, boolean whiteBoard, boolean experimentTable) {
		this.studentNumbers = studentNumbers;
		this.projector = projector;
		this.blackBoard = blackBoard;
		this.whiteBoard = whiteBoard;
		this.experimentTable = experimentTable;
	}*/
	
	public static void main(String[] args) throws SQLException {
		addRoomCriteria("Trym Blaauw", "TDT4140", 400, false, false, false);
	}
	
}
