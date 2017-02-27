package RooMe;

import java.util.ArrayList;

public class sokRom {
	
	//FILE NOT IN USE AT THE MOMENT

	static ArrayList<Room> roomlist = new ArrayList<Room>(); //might be removed
	static ArrayList time = new ArrayList<>();
	
	public  static ArrayList updateTime(){
		for (int i = 0; i < 10; i++) {
			time.add(i);
		}
		return time;
	}
	
	//old function most likely not useable
/*	public static void findRooms(String name, int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard){
		for (int i = 0; i < roomlist.size(); i++) {
			System.out.println(roomlist.get(i));
		}
	}*/
	
	// if subject2.start is before subject1.end we have a problem
	
	public final static void checkTime(int start, int end){
		//String subject1 = "Matte";
		//String subject2 = "Fysikk";
		if (end < start) {
			System.out.println("We have a problem");
		}
	}
	
	public final static void bookRoom(int start, int end, Room r){
		//if room is booked between start and end time, we have a problem
		
	}
	
	public static void main(String[] args) {
		updateTime();
		System.out.println("tidsintervall man kan booke " + time);
		checkTime(3,2); //checkTime(start,end)
		
	}
}

