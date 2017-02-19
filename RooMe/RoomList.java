package RooMe;

import java.util.ArrayList;
import java.util.List;

public class RoomList {

	//attributes for liste of rooms
	private int roomCount;
	private String name;
	static ArrayList<Room> romliste = new ArrayList<Room>(); //add Room as type specification
	
	public RoomList(String name) {
		this.name = name;
		
	}
	
	public static void findRooms(String name, int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard){
		for (int i = 0; i > romliste.size(); i++) {
			 System.out.println(romliste.get(i));
		}
	}
	
	public ArrayList<Room> addRoom(Room room){ //add Room room as input
		romliste.add(room);
		return (ArrayList<Room>) romliste;
	}
	
	//getters and setters
	String getName() {
		return name;
	}

	//possible that name should be unchangeable
	void setName(String building) {
		this.name = building;
	}

	
	public static void main(String[] args) {
		RoomList romliste = new RoomList("Gløshaugen");
		//System.out.println(romliste.getName());
		Room rom = new Room("Test",10, true, true, true, true);
		romliste.addRoom(rom);
		//System.out.println(rom);
		findRooms("Test",10, true, true, true, true);
		System.out.println(romliste.getLength());
	}


	
}
