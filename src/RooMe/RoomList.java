package RooMe;

import java.util.ArrayList;
import java.util.Hashtable;

public class RoomList {

	private int RoomCount;
	private String name;
	private Hashtable<Integer, Room> roomIDList; 
		
	public RoomList(String name) {
		setName(name);
		this.roomIDList = new Hashtable<Integer, Room>();
		roomIDList.size();
	}
	
	public void getSize(){
		int RoomCount = roomIDList.size();
	}
	
	public void findRooms(){		
	}	
	
	public void addRoom(Room room){ //add Room room as input
		int RoomID = room.getRoomID(room);
		if (RoomID == 0) {
			RoomID = roomIDList.size() +1;
			while (roomIDList.containsKey(RoomID)){
				RoomID++;
				}
		}
		room.setRoomID(roomIDList.size()+1);
		roomIDList.put(RoomID, room);
	}
	
	String getName() {
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
		Room rom = new Room("s22", 50, false,false,false,false);
		roomlist.addRoom(rom);
		System.out.println(roomlist.getName());
		System.out.println(roomlist.roomIDList);
	}


	
}
