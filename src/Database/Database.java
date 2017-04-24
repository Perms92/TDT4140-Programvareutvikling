package Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import RooMe.Person;
import RooMe.Room;
import RooMe.RoomCriteria;
	
public class Database {
	
	public static Connection conn=null;
	public static Statement sment=null;
	public static ResultSet rs=null;
	//ForBedreKode(FBK): Innkapsle attributtene og legg til getters
	public static ArrayList<Room> allRooms = new ArrayList<Room>();
	public static ArrayList<RoomCriteria> allCriteria = new ArrayList<RoomCriteria>();
	public static Set<String> distinctPersons = new HashSet<>();
	
	public Database() throws SQLException {
		fetchRooms();
		fetchCriteria();
		fetchDistinctPersons();
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
		//may need to make new timetables for persons who arent registered 
		ArrayList<String> persons = new ArrayList<String>();	
		try {
				Database.rs = Database.sment.executeQuery(sql);
				while (Database.rs.next()){
					persons.add(Database.rs.getString(1));
					RoomCriteria aCrit = 
					new RoomCriteria(Database.rs.getString(1), Database.rs.getString(2), Database.rs.getInt(3), 
							Database.rs.getBoolean(4), Database.rs.getBoolean(5), Database.rs.getBoolean(6), Database.rs.getInt(7));
					allCriteria.add(aCrit);
					} 
				for (String name : persons) {
					if (Person.getPerson(name) == null) {
						new Person(name, true);
					}
				}
				}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void fetchDistinctPersons() {
		String sql = "select * from thblaauw_tdt4145database.Criterias";
		try {
			Database.rs = Database.sment.executeQuery(sql);
			while (Database.rs.next()){
				distinctPersons.add(Database.rs.getString(1));
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
	
	public Set<String> getDistinctPersons() {
		return distinctPersons;
	}
	
	public static void removeEqualRoom(String roomName, ArrayList<Room> list) {
		Iterator<Room> iter = list.iterator();

		while (iter.hasNext()) {
		    Room next = iter.next();

		    if (roomName.equals(next.getName()))
		        iter.remove();
		}
	}
	
	public static ArrayList<RoomCriteria> extractDuplicates(ArrayList<RoomCriteria> critList, ArrayList<ArrayList<Room>> listOfLists) {
		//method removes criteria from same person leaving only one, 
		//namely the first criterion (in assign rooms, the one with the most matches)
		//also removes equivalent matches from the matrix
		
		ArrayList<RoomCriteria> extracted = new ArrayList<RoomCriteria>();
		ArrayList<Integer> matchingIndexes = new ArrayList<Integer>();
		for (RoomCriteria crit : critList) {
			int i =critList.indexOf(crit);
			for (int next = i+1; next < critList.size(); next++) {
				RoomCriteria indexedCrit = critList.get(next);
				//must iterate through whole list, then extract to avoid ConcurrentModificationException
				if (extracted.contains(crit)) {
					//Crit already added as this is a duplicate - do nothing
				}
				//IMPROVEMENT: this code only works when no one has the (exact) same name, let name be username or use PersonID
				else if (crit.getPersonName().equals(indexedCrit.getPersonName())) {
						System.out.println("adding" + indexedCrit);
						extracted.add(indexedCrit);
						// will remove matches for the indexedCrit, but then indexes changes
						matchingIndexes.add((Integer) next);
						
					
				}
			}
		} 
		Collections.sort(matchingIndexes);
		System.out.println("These are to be removed:");
		System.out.println("Indexes: " + matchingIndexes);
		for (int size=matchingIndexes.size()-1; size >=0; size--) {
			int removeFromMatrix = matchingIndexes.get(size);
			listOfLists.remove(removeFromMatrix);
			System.out.println("Index " + removeFromMatrix + "removed");
			System.out.println("New size = " + listOfLists.size());
		}
		critList.removeAll(extracted);
		return extracted;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		
	/*	Database test = new Database();
		System.out.println(test.getAllRooms());
		System.out.println(test.getAllCriteria());
		System.out.println(test.getDistinctPersons());*/
	}
	
}
