package RooMe;

import java.sql.SQLException;
import java.util.ArrayList;

public class AssignRooms {
	/*
	 * This class is suppose to give a room with a specific time for every criteria
	 *  Main part of the project
	 */
	
	/*
	 * spørsmål trym:
	 * Hvorfor ikke 1 class for å sette criterier og 1 for å lese?
	 * Hvorfor extender RoomCriteria Room?
	 * 
	 * ___
	 * hent kriteria fra database
	 * gjør søk per kriteria
	 * lagre mulige treff
	 * sjekk treff mot hverandre og fordel slik at alle klaffer
	 */
	public static ListOfCriteria crits = new ListOfCriteria();
	public static ArrayList<Criterion> criteriaList;
	
	public static void InitCrits() {
		crits.makeCrits();
		criteriaList = crits.criteriaList;
	}
	
	public static SearchForRoomDB roomDB;
	public static ArrayList<Room> rooms;
	
	public static void InitRooms() {
		try {
			roomDB = new SearchForRoomDB(0, false, false, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			rooms = roomDB.acceptedRooms;
		}
	}

	public static void IterateList(ArrayList list) {
		for (Object ob : list) {
			System.out.println("Objekt: " + ob);
		}
	}
	
	public static ArrayList potentialCombos = new ArrayList<>();
	
	public static void CombineSearch() {
		for (Criterion crit : criteriaList) {
			System.out.println(crit);
			for (Room room : rooms) {
				
				if (crit.getCapacity() < room.getCapacity()) {
					System.out.println(room.getName() + " is big enough");
				}
				if (crit.isProjector() == room.isProjector()) {
					System.out.println(room.getName() + " has projector");
				}
				if (crit.isBlackboard() == room.isBlackboard()) {
					System.out.println(room.getName() + " has blackboard");
				}
				if (crit.isHearingaid() == room.isWhiteboard()) {
					System.out.println(room.getName() + " has hearingaid");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		InitCrits();
		InitRooms();
	//	System.out.println(crits.criteriaList.get(0));
	//	IterateList(criteriaList);
	//	IterateList(rooms);
		CombineSearch();
	}
	
	//end tag
}
