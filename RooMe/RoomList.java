package RooMe;

import java.util.ArrayList;

public class RoomList {

	//attributes for liste of rooms
	private int roomCount;
	private String name;
	ArrayList liste = new ArrayList<Room>(); //add Room as type specification
	
	public RoomList(String name) {
		this.name = name;
		
	}
	
	public void findRooms(int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard){
		//if ();// sjekk rom mot egenskaper
	}
	
	public ArrayList addRoom(Room room){ //add Room room as input
		liste.add(room);
		return liste;
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
		System.out.println(romliste.getName());
		Room rom = new Room(10, true, true, true, true);
		romliste.addRoom(rom);
		System.out.println(romliste.getName());
	}


	
}
