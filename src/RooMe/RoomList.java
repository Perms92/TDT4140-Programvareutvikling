package RooMe;

import java.util.ArrayList;

public class RoomList {


	//attributes for liste of rooms
	//private int roomCount; //if we want to know how many rooms a building/place has

	private String name;
	static ArrayList<Room> roomlist = new ArrayList<Room>();
	
	public RoomList(String name) {
		this.name = name;
	}
	
	public ArrayList<Room> addRoom(Room room){
		roomlist.add(room);
		return roomlist;
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
		RoomList roomlist = new RoomList("Gløshaugen");
		Room rom = new Room("Rom 1",10, true, true, true);
		roomlist.addRoom(rom);
		Room rom2 = new Room("Rom 2",20, true, false, true);
		roomlist.addRoom(rom2);
		Room rom3 = new Room("Rom 3",50, false, false, false);
		roomlist.addRoom(rom3);
		System.out.println(roomlist);
	}	

		/* setName(name);
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

	 IKKE NØDVENDIG
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
*/

	

}
