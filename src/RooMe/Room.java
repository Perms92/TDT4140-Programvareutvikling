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
<<<<<<< HEAD
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
=======
		setSpace(capacity);
		setProjector(projector);
		setBlackboard(blackboard);
		setWhiteboard(whiteboard);
		setName(name);
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
	public int getSpace() {
		return capacity;
	}
	private void setSpace(int space) {
		this.capacity = space;
	}
	public boolean isProjector() {
		return projector;
	}
	private void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean isBlackboard() {
		return blackboard;
	}
	private void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}
	public boolean isWhiteboard() {
		return whiteboard;
>>>>>>> semi-master
	}
	
	public static void getRooms() {
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
	
<<<<<<< HEAD
	/* SKAL IKKE VÆRE MULIG Å GI NULL SOM NAVN LENGER
	 if (name == "null") {
		try {
			Database.sment.executeUpdate("DELETE FROM thblaauw_tdt4145database.Room"
					+ " WHERE Room.Name IS NULL");
			System.out.println("The room(s) without name(s) are deleted from the database.\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Database.disconnect();
			}
	else {*/
		try {
	
			Database.sment.executeUpdate("DELETE FROM thblaauw_tdt4145database.Room"
					+ " WHERE Room.Name ='" + name + "'");
			System.out.println("The room with name: "+name+" is deleted from the database.\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	public static void main(String[] args) throws SQLException {
		//addRoom("R1", 80, false, false, false);
		//deleteRoom("R1");
		getRooms();
	}
	}
=======
	@Override 
	public String toString(){
		return "Name: " + name + "\t" + capacity + "\t" + projector + "\t" + whiteboard + "\t" + blackboard  + "\t";
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
>>>>>>> semi-master
