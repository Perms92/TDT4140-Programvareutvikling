package RooMe;

import java.util.ArrayList;

public class RoomList {
	
	private int roomCount;
	private String name;
	public static ArrayList<Room> roomlist = new ArrayList<Room>();
	
	public RoomList(String name) {
		this.name = name;
		
	}
	
	public void findRooms(){
		
	}	
	
	public void addRoom(Room rom){
		roomlist.add(rom);
	}
	
	String getName() {
		return name;
	}

	void setName(String building) {
		this.name = building;
	}

	
	public static void main(String[] args) {
		RoomList roomlist = new RoomList("Gløshaugen");
		Room rom = new Room("s22", 50, false,false,false,false);
		roomlist.addRoom(rom);
		System.out.println(roomlist.getName());
		System.out.println(roomlist.roomlist);
	}


	
}
