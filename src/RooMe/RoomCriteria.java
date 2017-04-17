package RooMe;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.Database;

public class RoomCriteria{
	
	static ArrayList<RoomCriteria> list = new ArrayList<RoomCriteria>();
	
	public String PersonName;
	public String fag;
	private int capacity;
	private boolean projector;
	private boolean blackboard;
	private boolean hearingaid;

	public ArrayList<Room> criterionCombos = new ArrayList<Room>();
	
	protected RoomCriteria(String PersonName, String fag, int capacity, boolean projector, boolean blackboard, boolean whiteboard) {
		setPersonName(PersonName);
		setFag(fag);
		setCapacity(capacity);
		setProjector(projector);
		setBlackboard(blackboard);
		setHearingaid(whiteboard);
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
	
	public static ArrayList<RoomCriteria> listOfCriterion() throws SQLException{
		//ArrayList<RoomCriteria> list = new ArrayList<RoomCriteria>();
		String sql = "select * from thblaauw_tdt4145database.Criterias";
		Database.connect();
			try {
				Database.rs = Database.sment.executeQuery(sql);
				while (Database.rs.next()){
					RoomCriteria aCrit = 
					new RoomCriteria(Database.rs.getString(1), Database.rs.getString(2), Database.rs.getInt(3), 
							Database.rs.getBoolean(4), Database.rs.getBoolean(5), Database.rs.getBoolean(6));
					list.add(aCrit);
					} 
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}
		
	
	
	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public String getFag() {
		return fag;
	}

	public void setFag(String fag) {
		this.fag = fag;
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

	public boolean isHearingaid() {
		return hearingaid;
	}

	
	public String toString() {
		String PersonName = getPersonName();
		String fag = getFag();
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
		return  PersonName + " 	|	 " + fag + " 	|	 " + capacity + " 	|	 " + textprojector + " 	|	 " + textblackboard + " 	|	 " + textwhiteboard + "\n"; 
	}


	public void setHearingaid(boolean whiteboard) {
		this.hearingaid = whiteboard;
	}

	public static void main(String[] args) throws SQLException {
		//addRoomCriteria("Kristian Langvann", "TMA4100", 200, true, false, false);
//		getRoomCriterias();
//		ArrayList<RoomCriteria> testList = listOfCriterion();
//		System.out.println(testList);
		
	}
	
}
