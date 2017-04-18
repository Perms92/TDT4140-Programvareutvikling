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
	
	public AssignRooms() {
		InitCrits();
		InitRooms();
		System.out.println(criteriaList);
		System.out.println(rooms + "\n \n");
		CombineSearch();
		SortCriterias();
		System.out.println(listOfLists);
		delegateRooms();
	//	delegateRoomsInput(listOfLists, criteriaList);
	}
	
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
	
	//updating local room list from database
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
	
	//function that adds possible rooms into the criteriaclass
	public static void CombineSearch() {
		for (RoomCriteria crit : criteriaList) {
			for (Room room : rooms) {
				if (crit.getCapacity() <= room.getCapacity()) {
					if ((crit.isProjector() == room.isProjector()) || crit.isProjector() == false) {
						if ((crit.isBlackboard() == room.isBlackboard()) || crit.isBlackboard() == false) {
							if ((crit.isHearingaid() == room.isWhiteboard()) || crit.isHearingaid() == false) {
								crit.criterionCombos.add(room);
							}
						}
					}
				}			
			}
			System.out.println(crit.getPersonName()+":  " + crit.criterionCombos + "\n \n");
		}
	}
	
	//list to sort criteria in
	public static ArrayList<ArrayList<Room>> listOfLists = new ArrayList<>();
	public static ArrayList<RoomCriteria> sortedCriterias = new ArrayList<>();
	
	public static void SortCriterias () {
		int size = 0;
		int maxRes = 0; //size of longest list in criteriaList
		while  (size < maxRes + 1) {
			for (RoomCriteria crit : criteriaList) {
				if (crit.criterionCombos.size() == size) {
					listOfLists.add(crit.criterionCombos);
					sortedCriterias.add(crit);
					System.out.println(crit.getPersonName() + crit.getFag() + crit.getCapacity());
				}
				if (crit.criterionCombos.size() > maxRes) {
					maxRes = crit.criterionCombos.size();
				}
			}	
			size++;
		}
	}
	
	public static ArrayList<Combo> combos = new ArrayList<>();
	public static ArrayList<RoomCriteria> noRooms  = new ArrayList<>();
	
	public static void delegateRooms() {
		for (int i = 0; i < listOfLists.size(); i++ ) {
			if (listOfLists.get(i).size() == 0) {
				noRooms.add(criteriaList.get(i));
				System.out.println("no rooms " + noRooms);
			}
			//if (listOfLists.get(i).size() == 1) {
			else {	
				Combo com = new Combo(sortedCriterias.get(i), (listOfLists.get(i)).get(0));
				combos.add(com);
	//			criteriaList.remove(i);
				Room room = (listOfLists.get(i).get(0)); //this one is given somewhere
	//			System.out.println("added" +  (listOfLists.get(i)));
				for (ArrayList<Room> list : listOfLists) {
					if (list.contains(room)) {
						list.remove((room));
	//					System.out.println("contains" + list + (listOfLists.get(i)) );
					}

				}
			}
		}
		System.out.println("New time");
		
	}
	
	public static void main(String[] args) {
		new AssignRooms();
		System.out.println(combos);
	}

	public static void delegateRoomsInput(ArrayList<ArrayList<Room>> rom, ArrayList<RoomCriteria> crit) {
		noRooms  = new ArrayList<>();
		for (int i = 0; i < rom.size(); i++ ) {
			if (rom.get(i).size() == 0) {
//				noRooms.add(crit.get(i));
//				listOfLists.remove(i);
		//		System.out.println(crit.get(0));
	//			System.out.println("no rooms " + noRooms);
			}
			else {	
				Combo com = new Combo((crit.get(i)), (rom.get(i)).get(0));
				combos.add(com);
				Room room = (rom.get(i).get(0)); //this one is given somewhere
				for (ArrayList<Room> list : rom) {
					if (list.contains(room)) {
						list.remove((room));
					}
				}
			}
		}
		System.out.println("ikke tildelt rom " + noRooms);
		System.out.println("New time");
		System.out.println(listOfLists);
		delegateRoomsInput(listOfLists, noRooms);
	}
	
	//end tag
}
