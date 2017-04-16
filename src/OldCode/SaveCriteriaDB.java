package OldCode;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Database.Database;

public class SaveCriteriaDB {

	
	
	
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
}
