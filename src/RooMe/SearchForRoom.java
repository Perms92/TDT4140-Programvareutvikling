package RooMe;

import java.util.ArrayList;

public class SearchForRoom {
	private static ArrayList<Room> acceptedRooms = new ArrayList<>();
	
	public SearchForRoom(Database database, int space, boolean projector, boolean blackboard, boolean whiteboard) {
		//must fix so it doesnt add rooms that are too small
		if (space < space) {
			CheckSize(database, space);
		}
		if (projector == true) {
			CheckProjector(database, projector);
		}
		if (blackboard == true) {
			CheckBlackboard(database, blackboard);
		}
		if (whiteboard == true) {
			CheckWhiteboard(database, whiteboard);
		}
		
		/*for (Object room : Database.Database) {
			if (((Room) room).getSpace() >= capacity) {
				acceptedRooms.add((Room) room);
				System.out.println((((Room) room).getName()));
			}
		}
		for (Object room : acceptedRooms) {
			if (((Room) room).getCapacity() >= capacity) {
				acceptedRooms.add((Room) room);
				//System.out.println((((Room) room).getName()));
			}
		}*/
	}
	
	//check if room is big enough
	public static ArrayList CheckSize(Database database, int capacity) {
		acceptedRooms = new ArrayList<>();
		for (Object room : Database.Database) {
			if (((Room) room).getSpace() >= capacity) {
				acceptedRooms.add((Room) room);
				//System.out.println((((Room) room).getName()));
			}
		}
		return acceptedRooms;
	}
	
	//check if room has blackboard
	public static ArrayList CheckBlackboard(Database database, boolean blackboard) {
		acceptedRooms = new ArrayList<>();
		for (Object room : Database.Database) {
			if (((Room) room).isBlackboard() == blackboard) {
				acceptedRooms.add((Room) room);
				//System.out.println((((Room) room).getName()));
			}
		}
		return acceptedRooms;
	}
	
	//check if room has whiteboard
	public static ArrayList CheckWhiteboard(Database database, boolean whiteboard) {
		acceptedRooms = new ArrayList<>();
		for (Object room : Database.Database) {
			if (((Room) room).isWhiteboard() == whiteboard) {
				acceptedRooms.add((Room) room);
				//System.out.println((((Room) room).getName()));
			}
		}
		return acceptedRooms;
	}
		
	//check if room has projector
	public static ArrayList CheckProjector(Database database, boolean projector) {
		acceptedRooms = new ArrayList<>();
		for (Object room : Database.Database) {
			if (((Room) room).isProjector() == projector) {
				acceptedRooms.add((Room) room);
				//System.out.println((((Room) room).getName()));
			}
		}
		return acceptedRooms;
	}

	public static void IterateList() {
		for (int i = 0; i < acceptedRooms.size(); i++) {
			System.out.println("Godkjente rom er: Rom " + acceptedRooms.get(i).getName() + 
					", kapasitet " + acceptedRooms.get(i).getSpace() + 
					", prosjektor " + acceptedRooms.get(i).isProjector() +
					", whiteboard " + acceptedRooms.get(i).isWhiteboard() +
					", blackboard " + acceptedRooms.get(i).isBlackboard());
		}
	}
	
	public static void main(String[] args) {
		Database database = new Database("Test");
		Database.IterateList();
		new SearchForRoom(database, 50, true, false, true); //SearchForRoom sok = trenger ikke opprette en klasse
		IterateList();
	}

	
}
