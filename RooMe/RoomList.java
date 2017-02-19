package RooMe;

import java.util.ArrayList;

public class RoomList {

	//attributes for liste of rooms
	//private int roomCount; //if we want to know how many rooms a building/place has
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
		Room rom = new Room("Rom 1",10, true, true, true, true);
		romliste.addRoom(rom);
		Room rom2 = new Room("Rom 2",20, true, false, false, true);
		romliste.addRoom(rom2);
		Room rom3 = new Room("Rom 3",50, false, false, false, false);
		romliste.addRoom(rom3);
		System.out.println(romliste);
	}	
}
