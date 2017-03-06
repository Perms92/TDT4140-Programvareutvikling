package RooMEbeta;

import java.util.ArrayList;

public class RoomSearch {
	private static ArrayList<Room> acceptedRooms = new ArrayList<>();
	
	public RoomSearch(RoomDatabase database, int capacity) {
		for (Object room : database.Database) {
			if (((Room) room).getCapacity() >= capacity) {
				acceptedRooms.add((Room) room);
				System.out.println((((Room) room).getName()));
			}
		}
		/*for (Object room : acceptedRooms) {
			if (((Room) room).getCapacity() >= capacity) {
				acceptedRooms.add((Room) room);
				//System.out.println((((Room) room).getName()));
			}
		}*/
	}

	public static void IterateList() {
		for (int i = 0; i < acceptedRooms.size(); i++) {
			System.out.println("Godkjente rom er: Rom " + acceptedRooms.get(i).getName() + ", kapasitet " + acceptedRooms.get(i).getCapacity());
		}
	}
	
	public static void main(String[] args) {
		RoomDatabase database = new RoomDatabase("Test");
		database.IterateList();
		RoomSearch sok = new RoomSearch(database, 50);
		IterateList();
	}

	
}
