package RooMe;

import java.util.ArrayList;

public class Database {
	
	private String Databasename;
	static ArrayList<Room> Database = new ArrayList<>(); //to access from other classes
	
	//constructor
	public Database(String name) {
		this.Databasename = name;
		initializeDatabase();
	}
	
	//setup list with 5 rooms, testdatabase
	public static void initializeDatabase() {
		Room room1 = new Room("R1", 80, false, false, false, false);
		Room room2 = new Room("R2", 70, true, true, false, false);
		Room room3 = new Room("R3", 60, true, true, true, true);
		Room room4 = new Room("R4", 50, false, true, false, false);
		Room room5 = new Room("R5", 40, true, true, true, true);
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
			System.out.println("Rom " + Database.get(i).getName() + 
					", kapasitet " + Database.get(i).getSpace() + 
					", prosjektor " + Database.get(i).isProjector() +
					", whiteboard " + Database.get(i).isWhiteboard() +
					", blackboard " + Database.get(i).isBlackboard());
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
	
	String getDatabasename() {
		return Databasename;
	}

	void setDatabasename(String databasename) {
		Databasename = databasename;
	}

	public static void main(String[] args) {
		Database base = new Database("Gløs");
		System.out.println("Det er " + base.countRooms() + " rom i denne listen");
		base.addRoom(new Room("R6", 10, true, true, false, false)); //adding a new room in the database
		System.out.println("Det er " + base.countRooms() + " rom i denne listen");
		System.out.println(base.getDatabasename());
		base.IterateList();
	}
}
