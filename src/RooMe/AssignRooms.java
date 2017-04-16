package RooMe;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	
	//list with input criterias that we use to search for rooms
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
	
	//list of rooms that can be combined with our criteria
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
			System.out.println("possible rooms " + crit.criterionCombos.size());
		}
	}
	
	//list to sort criteria in
	public static ArrayList listOfLists = new ArrayList<>();
	
	public static void SortCriterias () {
		int i = 0;
		int size = 0;

		while (i < (criteriaList.size())) {
			for (RoomCriteria crit : criteriaList) {
				if (crit.criterionCombos.size() == size) {
					listOfLists.add(crit.criterionCombos);
					i++;
				}
				else {
				}		
			}	
			size++;
		}
	}
	

	
	public static void main(String[] args) {
		InitCrits();
		InitRooms();
		CombineSearch();
//		Combos();
		SortCriterias();
//		System.out.println(listOfLists);
	}
	
	//end tag
}
