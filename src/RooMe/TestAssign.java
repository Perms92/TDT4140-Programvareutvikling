package RooMe;

import java.sql.SQLException;
import java.util.ArrayList;

public class TestAssign {
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
	
	public TestAssign() {
		InitCrits();
		InitRooms();
		CombineSearch(criteriaList);
		SortCriterias(criteriaList);
		delegateRooms();

	}
	
	//list with input criterias that we use to search for rooms
	public static ArrayList<RoomCriteria> criteriaList;
	
	public static void InitCrits() {
		try {
			RoomCriteria.listOfCriterion();
			//System.out.println("listOfCriterion");
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
	public static void CombineSearch(ArrayList<RoomCriteria> crits) {
		for (RoomCriteria crit : crits) {
			
			for (Room room : rooms) {
				
				if (crit.getCapacity() <= room.getCapacity()) { // if room as bigger capacity than needed
					if ((crit.isProjector() == false) || (crit.isProjector() == room.isProjector())  ) { //if room has projector or crit doesnt need
						if ((crit.isBlackboard() == false) || (crit.isBlackboard() == room.isBlackboard())) { //if room has blackboard or crit doesnt need
							if ((crit.isHearingaid() == false) || (crit.isHearingaid() == room.isWhiteboard())) { //if room has hearingaid or crit doesnt need
								crit.criterionCombos.add(room);
								System.out.println(crit + "," + room);
							}
						}
					}
				}			
			}
		}
	}
	
	//list to sort criteria in
	public static ArrayList<ArrayList<Room>> listOfLists = new ArrayList<>();
	public static ArrayList<RoomCriteria> sortedCriteria = new ArrayList<>();
	
	public static void SortCriterias (ArrayList<RoomCriteria> crits) {
		listOfLists = new ArrayList<>();
		int size = 0;
		int maxRes = 0; //size of longest list in criteriaList
		while  (size < maxRes + 1) {
			for (RoomCriteria crit : crits) {
				//this if sentence adds criterion with  (0, 1, 2...n) possible roomcombinations in the list, to keep the list ordered
				if (crit.criterionCombos.size() == size) {
					listOfLists.add(crit.criterionCombos);	
					sortedCriteria.add(crit);
				}
				//this if-sentence finds the criterion with be most acceptable rooms and therefore how many iterations we need
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
		noRooms  = new ArrayList<>();
		for (int i = 0; i < listOfLists.size(); i++ ) {
//			System.out.println("size " + listOfLists.get(i).size());
//			System.out.println("i " + i);
			if ((listOfLists.get(i)).size() == 0) {
				noRooms.add(sortedCriteria.get(i));
//				System.out.println("added" + (criteriaList.get(i)).getSubject());
			}
			else {	
				Combo com = new Combo((sortedCriteria.get(i)), (listOfLists.get(i)).get(0));
				combos.add(com);
				Room room = (listOfLists.get(i).get(0)); //this one is given somewhere
				for (ArrayList<Room> list : listOfLists) {
					if (list.contains(room)) {
						list.remove((room));
					}

				}
			}
		}

		System.out.println("New time");
		System.out.println("Crits without room " + noRooms.size() + "\n"
				+ noRooms);
//		CombineSearch(noRooms);
//		SortCriterias(noRooms);
//		System.out.println(listOfLists);
	//	if (noRooms.size() > 0) { 
	//		SortCriterias(noRooms);
	//		delegateRooms();
	//	} 
	}
	
	public static void main(String[] args) {
		new TestAssign();
		System.out.println(combos);
	}

	
	//end tag
}
