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
	
	public static ArrayList<RoomCriteria> criteriaList;
	
	public static void InitCrits() {
		try {
			RoomCriteria.listOfCriterion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			criteriaList = RoomCriteria.list;
		}
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
	
	public static void CombineSearch() {
		for (RoomCriteria crit : criteriaList) {
			for (Room room : rooms) {
				if (crit.getCapacity() < room.getCapacity()) {
					if ((crit.isProjector() == room.isProjector()) || crit.isProjector() == false) {
						if ((crit.isBlackboard() == room.isBlackboard()) || crit.isBlackboard() == false) {
							if ((crit.isHearingaid() == room.isWhiteboard()) || crit.isHearingaid() == false) {
								crit.criterionCombos.add(room);
							}
						}
					}
				}			
			}
		}
	}
	
	public static void Combos () {
		for (RoomCriteria crit : criteriaList) {
			System.out.println(crit.criterionCombos);
		}
	}
	
	public static void main(String[] args) {
		InitCrits();
		InitRooms();
		CombineSearch();
		Combos();
	}
	
	//end tag
}
