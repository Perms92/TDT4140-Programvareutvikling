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
	
	public static void getRoomCriterias() {
		Database.connect();
		try {
			Database.rs = Database.sment.executeQuery("select * from thblaauw_tdt4145database.Criterias");
			System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s","Foreleser", "Fag", "Capacity", "Projector", "Blackboard", "Whiteboard"+"\n");
			System.out.println("---------------------------------------------------------------------------------------------");
			while (Database.rs.next()){
				System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s"
						+ "", Database.rs.getString(1),
									Database.rs.getString(2),
									Database.rs.getInt(3),
									Database.rs.getBoolean(4),
									Database.rs.getBoolean(5),
									Database.rs.getBoolean(6));
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.disconnect(); 
	}
		
	public static void main(String[] args) throws SQLException {
		addRoomCriteria("Kristian Langvann", "TMA4100", 200, true, false, false);
		getRoomCriterias();
	}
	
}
