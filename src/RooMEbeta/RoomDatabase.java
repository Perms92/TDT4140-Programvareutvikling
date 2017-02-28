package RooMEbeta;

import java.util.ArrayList;

public class RoomDatabase {
	
	private String Databasename;
	private static ArrayList<Room> Database = new ArrayList<>();
	
	//constructor
	public RoomDatabase(String name) {
		this.Databasename = name;
		initializeDatabase();
	}
	
	//setup list with 5 rooms, testdatabase
	public static void initializeDatabase() {
		Room room1 = new Room("R1", 50, false, false);
		Room room2 = new Room("R2", 50, true, true);
		Room room3 = new Room("R3", 50, true, false);
		Room room4 = new Room("R4", 50, false, true);
		Room room5 = new Room("R5", 40, true, true);
		Database.add(room1);
		Database.add(room2);
		Database.add(room3);
		Database.add(room4);
		Database.add(room5);
		//return Database; //using a static void instead of returning a new list
	}
	
	//adding a new room in our list
	public static void addRoom(Room room) {
		Database.add(room);
	}
	
	//returning how many rooms we have in our list
	public static int countRooms() {
		return Database.size();
	}
	
	//test search in list (database)
	public static void IterateList() {
		for (int i = 0; i < Database.size(); i++) {
			System.out.println("Rom " + Database.get(i).getName() + ", kapasitet " + Database.get(i).getCapacity());
		}
	}
	
	
	//Check if a specific room has projector
	public static boolean checkProjector() {
		if ((Database.get(0).isProjector()) == true) {
			return Database.get(0).isProjector();
		}
		else {
			return Database.get(0).isProjector();
		}
	}
	
	/* for i for j 
	 * for (Object day : days) {
			for (Object t : time) {
				System.out.println(day + " : " + t);
			}
		}
	 */
	
	String getDatabasename() {
		return Databasename;
	}

	void setDatabasename(String databasename) {
		Databasename = databasename;
	}

	public static void main(String[] args) {
		RoomDatabase base = new RoomDatabase("Gløs");
		System.out.println("Det er " + base.countRooms() + " rom i denne listen");
		base.addRoom(new Room("R6", 10, true, true)); //adding a new room in the database
		System.out.println("Det er " + base.countRooms() + " rom i denne listen");
		System.out.println(base.getDatabasename());
		base.IterateList();
	}
}
