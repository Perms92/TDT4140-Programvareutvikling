package RooMe;

import java.util.ArrayList;

public class RoomList {

	//attributes for liste of rooms
	//private int roomCount;
	private String name;
	static ArrayList<Room> romliste = new ArrayList<Room>();
	
	public RoomList(String name) {
		this.name = name;
	}
	
	public ArrayList<Room> addRoom(Room room){
		romliste.add(room);
		return romliste;
	}
	
	//getters and setters
	String getName() {
		return name;
	}

	//possible that name should be unchangeable
	void setName(String buildingName) {
		this.name = buildingName;
	}
	
	public static void main(String[] args) {
		RoomList romliste = new RoomList("Gløshaugen");
		Room rom = new Room("Test",10, true, true, true, true);
		romliste.addRoom(rom);
		Room rom2 = new Room("Test",20, true, false, false, true);
		romliste.addRoom(rom2);
		System.out.println(romliste);
	}	
}
