package RooMe;

import java.sql.*;



import Database.Database;

public class Room{

	private int capacity;
	private boolean projector;
	private boolean blackboard;
	private boolean whiteboard;
	private String name;
	private int roomID;
	
	protected Room(String name, int capacity, boolean projector, boolean blackboard, boolean whiteboard) {
	}
	
	public int getRoomID() {
		return roomID;
	}
	protected void setRoomID(int ID) {
		this.roomID = ID;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	
	/*private void setCapacity(int capacity) {
		this.capacity = capacity;
	}*/
	
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
	
	/*public static void addGoal(Goal goal) throws SQLException{
		Database.connect();
		String sql = "INSERT INTO oyvorsh_treningsdatabase.Maal\n"
				+ "(oID, Beskrivelse, fraDato, tilDato)\n"
				+ "VALUES(?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, goal.getoID());
		statement.setString(2, goal.getBeskrivelse());
		statement.setDate(3, goal.getTilDato());
		statement.setDate(4, goal.getFraDato());
		statement.executeUpdate();
		Database.disconnect();
	}*/
	
	public boolean isProjector() {
		return projector;
	}

	public boolean isBlackboard() {
		return blackboard;
	}
	private void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}
	public boolean isWhiteboard() {
		return whiteboard;
	}
	private void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;

	}

	
	

	public static void main(String[] args) throws SQLException {
		addRoom("R1", 80, false, false, false);
	}
	

}
