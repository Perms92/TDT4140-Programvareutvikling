package RooMe;

import java.util.ArrayList;
import java.util.Hashtable;

public class RoomList {

	//attributes for list of rooms
	private String name;
	private Hashtable<Integer, Room> roomIDList; 
	
	public RoomList(String name) {
		setName(name);
		this.roomIDList = new Hashtable<Integer, Room>();
		
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
	
	
	//getters and setters
	String getName() {
		return name;
	}

	//possible that name should be unchangeable
	private void setName(String building) {
		this.name = building;
	}

	public String toString() {
		System.out.println(roomIDList);
		return "kuk";
	}
	public static void main(String[] args) {
		RoomList romliste = new RoomList("Gløshaugen");
		romliste.addRoom(new Room("R1", 500, true, true, true, false));
		System.out.println(romliste);
	}


	
}
