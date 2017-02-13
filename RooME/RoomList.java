package RooME;

import java.util.ArrayList;

public class RoomList {

	//attributes for liste of rooms
	private int roomCount;
	private String name;
	ArrayList liste = new ArrayList(); //add Room as type specification
	
	public RoomList(String name) {
		this.name = name;
		
	}
	
	public void findRooms(){
		
	}
	
	public ArrayList addRoom(){ //add Room room as input
		liste.add("room");
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
	}


	
}
