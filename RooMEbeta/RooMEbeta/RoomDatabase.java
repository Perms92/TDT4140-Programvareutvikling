package RooMEbeta;

import java.util.ArrayList;

public class RoomDatabase {
	
	private int RoomCount;
	private String Databasename;
	private static ArrayList<Room> Database = new ArrayList<>();
	
	public static ArrayList<Room> initializeDatabase() {
		Room room1 = new Room("R1", 50, false, false);
		Room room2 = new Room("R2", 50, true, true);
		Room room3 = new Room("R3", 50, true, false);
		Room room4 = new Room("R4", 50, false, true);
		Room room5 = new Room("R5", 40, false, false);
		Database.add(room1);
		Database.add(room2);
		Database.add(room3);
		Database.add(room4);
		Database.add(room5);
		return Database;
	}
	
	//test search in list (database)
	public static void IterateList() {
		for (int i = 0; i < Database.size(); i++) {
			System.out.println("Rom " + Database.get(i).getName() + ", kapasitet " + Database.get(i).getCapacity());
		}
	}
	
	public static void main(String[] args) {
		initializeDatabase();
		IterateList();
	}
}
