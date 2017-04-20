package Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import RooMe.Room;
import RooMe.RoomCriteria;
	
public class Database {
	
	public static Connection conn=null;
	public static Statement sment=null;
	public static ResultSet rs=null;
	//ForBedreKode(FBK): Innkapsle attributtene og legg til getters
	public static ArrayList<Room> allRooms = new ArrayList<Room>();
	public static ArrayList<RoomCriteria> allCriteria = new ArrayList<RoomCriteria>();
	
	public Database() throws SQLException {
		fetchRooms();
		fetchCriteria();
	}
	public static Statement getStatement(){
		return sment;
	}
	public static void connect(){
		try {
			Database.conn=DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/thblaauw_tdt4145database?user=thblaauw_tdt4145&password=ey877fja");
			sment=conn.createStatement();
			System.out.println("Connection made");
		} catch (SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
		}
	}
	
	public static void disconnect(){
		try {
			Database.conn.close();
			System.out.println("Disconnected");
		} catch (SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
		}
	}
	
	
	public static void fetchRooms() throws SQLException{
		allRooms = new ArrayList<Room>();
		String sql = "select * from thblaauw_tdt4145database.Room";
			try {
				Database.rs = Database.sment.executeQuery(sql);
				while (Database.rs.next()){
					Room roomMatch = 
					new Room(false, Database.rs.getString(1), Database.rs.getInt(2),Database.rs.getBoolean(3),Database.rs.getBoolean(4), Database.rs.getBoolean(5));
					allRooms.add(roomMatch); 
					} 
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void fetchCriteria() throws SQLException{
		//ArrayList<RoomCriteria> list = new ArrayList<RoomCriteria>();
		String sql = "select * from thblaauw_tdt4145database.Criterias";
			try {
				Database.rs = Database.sment.executeQuery(sql);
				while (Database.rs.next()){
					RoomCriteria aCrit = 
					new RoomCriteria(Database.rs.getString(1), Database.rs.getString(2), Database.rs.getInt(3), 
							Database.rs.getBoolean(4), Database.rs.getBoolean(5), Database.rs.getBoolean(6), Database.rs.getInt(7));
					allCriteria.add(aCrit);
					} 
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	public ArrayList<Room> getAllRooms(){
		return allRooms;
	}
	public ArrayList<RoomCriteria> getAllCriteria() {
		return allCriteria;
	}
	
	public static void removeEqualRoom(String roomName, ArrayList<Room> list) {
		/*Room toBeRemoved = null;
		for (Room room : list) {
			if (roomName.equals(room.getName())) {
				toBeRemoved = room;
			}
		list.remove(toBeRemoved);
		}*/
		Iterator<Room> iter = list.iterator();

		while (iter.hasNext()) {
		    Room next = iter.next();

		    if (roomName.equals(next.getName()))
		        iter.remove();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Database test = new Database();
		System.out.println(test.getAllRooms());
		System.out.println(test.getAllCriteria());

	}
	

}
