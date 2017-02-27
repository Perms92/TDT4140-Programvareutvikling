package RooMe;

import java.util.ArrayList;
import java.util.Hashtable;

public class RoomList {

	private String name;
	private Hashtable<Integer, Room> roomIDList; 
		
	public RoomList(String name) {
		setName(name);
		this.roomIDList = new Hashtable<Integer, Room>();
	}
	
	public int getSize(){
		return roomIDList.size();
	}
	
	
	public void addRoom(Room room){ //add Room room as input
		int RoomID = roomIDList.size() +1;
		while (roomIDList.containsKey(RoomID)){
			RoomID++;
		}
		room.setRoomID(RoomID);
		roomIDList.put(RoomID, room);
	}
	
	public String getName() {
		return name;
	}

	private void setName(String building) {
		this.name = building;
	}

	public String toString() {
		System.out.println(roomIDList);
		return "kuk";
	}
	public static void main(String[] args) {
		RoomList roomlist = new RoomList("Gløshaugen");
		Room room = new Room("s22", 50, false,false,false,false);
		roomlist.addRoom(room);
		Room room1 = new Room("s22", 50, false,false,false,false);
		roomlist.addRoom(room);
		Room room2 = new Room("s22", 50, false,false,false,false);
		roomlist.addRoom(room);
		Room room3 = new Room("s22", 50, false,false,false,false);
		roomlist.addRoom(room);
		System.out.println(roomlist.getName());
		System.out.println(roomlist);
		System.out.println(roomlist.roomIDList);
		
	}
	public Hashtable<Room, Integer> search() {
		return null;
		
	}


	
}
