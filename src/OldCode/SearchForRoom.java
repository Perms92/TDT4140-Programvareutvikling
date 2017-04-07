package OldCode;

import java.util.ArrayList;

import RooMe.Room;

public class SearchForRoom {
	/*
	 * Cannot search for experimentable rooms yet
	 */

	//public for now while testing GUI
	public static ArrayList<Room> acceptedRooms = new ArrayList<>();
	
	public SearchForRoom(OldDatabase database, int space, boolean projector, boolean blackboard, boolean whiteboard) {
		//make temporary list for different criteria
		ArrayList<Room> okRooms = new ArrayList<>();
		ArrayList<Room> projectorRooms = new ArrayList<>();
		ArrayList<Room> blackboardRooms = new ArrayList<>();
		ArrayList<Room> whiteboardRooms = new ArrayList<>();
		ArrayList<Room> sizeRooms = new ArrayList<>();
		
		//list of all rooms big enough
		sizeRooms = CheckSize(database, space);
		
		//list of all rooms that passes projector criteria
		if (projector == true) {
			projectorRooms = CheckProjector(database, projector);
		}
		else {
			projectorRooms = sizeRooms;
		}
		
		//list of all rooms that passes blackboard criteria
		if (blackboard == true) {
			blackboardRooms = CheckBlackboard(database, blackboard);
		}
		else {
			blackboardRooms = sizeRooms;
		}
		
		//list of all rooms that passes whiteboard criteria
		if (whiteboard == true) {
			whiteboardRooms = CheckWhiteboard(database, whiteboard);
		}
		else {
			whiteboardRooms = sizeRooms;
		}
		
		//iterating throgh all list making temporary lists with all accepted rooms
		for (Object room : sizeRooms) {
			if (projectorRooms.contains(room)) {
				if (whiteboardRooms.contains(room)) {
					if (blackboardRooms.contains(room)) {
						okRooms.add((Room) room);
					}
				}
			}
		}
		//setting list to all accepted rooms.
		this.acceptedRooms = okRooms;
	
	}
	
	//check if room is big enough
	public static ArrayList<Room> CheckSize(OldDatabase database, int capacity) {
		acceptedRooms = new ArrayList<>();
		for (Object room : OldDatabase.Database) {
			if (((Room) room).getSpace() >= capacity) {
				acceptedRooms.add((Room) room);
			}
		}
		return acceptedRooms;
	}
	
	//check if room has blackboard
	public static ArrayList<Room> CheckBlackboard(OldDatabase database, boolean blackboard) {
		acceptedRooms = new ArrayList<>();
		for (Object room : OldDatabase.Database) {
			if (((Room) room).isBlackboard() == blackboard) {
				acceptedRooms.add((Room) room);
			}
		}
		return acceptedRooms;
	}
	
	//check if room has whiteboard
	public static ArrayList<Room> CheckWhiteboard(OldDatabase database, boolean whiteboard) {
		acceptedRooms = new ArrayList<>();
		for (Object room : OldDatabase.Database) {
			if (((Room) room).isWhiteboard() == whiteboard) {
				acceptedRooms.add((Room) room);
			}
		}
		return acceptedRooms;
	}
		
	//check if room has projector
	public static ArrayList<Room> CheckProjector(OldDatabase database, boolean projector) {
		acceptedRooms = new ArrayList<>();
		for (Object room : OldDatabase.Database) {
			if (((Room) room).isProjector() == projector) {
				acceptedRooms.add((Room) room);
			}
		}
		return acceptedRooms;
	}

	public static void IterateList() {
		for (int i = 0; i < acceptedRooms.size(); i++) {
			System.out.println("Godkjente rom er: Rom " + acceptedRooms.get(i).getName()  + "\t" +  
					", kapasitet " + acceptedRooms.get(i).getSpace()  + "\t" +  
					", prosjektor " + acceptedRooms.get(i).isProjector()   + "\t" + 
					", blackboard " + acceptedRooms.get(i).isBlackboard()  + "\t" + 
					", whiteboard " + acceptedRooms.get(i).isWhiteboard());
		}
	}
	
	public static void main(String[] args) {
	/*
		Database database = new Database("Test");
		//Database.IterateList();
		new SearchForRoom(database, 50, true, false, true);
		IterateList();
		new SearchForRoom(database, 60, false, true, false);
		IterateList();
		*/
	}

	
}
