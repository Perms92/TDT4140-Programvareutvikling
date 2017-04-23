package RooMe;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.Database;

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
	
	public static Database database;
	//list to sort criteria in
	public static ArrayList<ArrayList<Room>> listOfLists = new ArrayList<>();
	public static ArrayList<RoomCriteria> critsBelong = new ArrayList<>();
	public static ArrayList<Combo> combos = new ArrayList<>();
	public static ArrayList<RoomCriteria> noRooms  = new ArrayList<>();
	
	public AssignRooms() throws SQLException {
		database = new Database();
	}
	
	public void AssignAllRooms() throws SQLException {
		CombineSearch(database.getAllCriteria());
		SortCriterias(database.getAllCriteria());
		delegateRooms(listOfLists);
		System.out.println("Combos first round: \n " + combos);
		System.out.println("Remaining criteria to satisfy: ");
		System.out.println(noRooms);
		assignCombosToTimeTable(0,1);
		System.out.println("Kommer fort ikke i rekkefølge");
		System.out.println("NoRooms etter 1 forsøk: " + noRooms + "\n" +"listOfLists etter 1 forsøk: " + listOfLists);
		int hourscount = 2;
		int daycount = 1;
			while (!(noRooms.isEmpty())) {
				System.out.println("NEW ROUND IN WHILE");
				delegateRemainingRooms();
				printlistOfLists();
				System.out.println(combos);
				System.out.println("Daycount and hourscount: " + daycount + ", " + hourscount);
				assignCombosToTimeTable(hourscount, daycount);
					if (hourscount < 6) {
						hourscount +=2;
						System.out.println("counted up");
					}
					else {
						hourscount = 0;
						daycount +=1;
						System.out.println("counted a day!");
					}
			}
	}
	
	public void delegateRemainingRooms() throws SQLException {
		listOfLists.clear();
		critsBelong.clear();
		combos.clear();
		CombineSearch(noRooms);
		SortCriterias(noRooms);
		delegateRooms(listOfLists);
		
	}
	
	//function that adds possible rooms into the criteriaclass
	public static void CombineSearch(ArrayList<RoomCriteria> criteriaList) throws SQLException {
		//list to sort criteria in
		for (RoomCriteria crit : criteriaList) {
			SearchForRoomDB fitToCrit = new SearchForRoomDB(crit.getCapacity(), crit.isProjector(), crit.isBlackboard(), crit.isHearingaid());
			crit.setPossibleRooms(fitToCrit.getAcceptedRooms());
			}
	}
		
		
	public static void SortCriterias (ArrayList<RoomCriteria> criteriaList) {
		int size = 0;
		int maxRes = 0; //size of longest list in criteriaList
		while  (size < maxRes + 1) {
			for (RoomCriteria crit : criteriaList) {
				//this if sentence adds criterion with  (0, 1, 2...n) possible roomcombinations in the list, to keep the list ordered
				if (crit.possibleRooms.size() == size) {
					listOfLists.add(crit.possibleRooms);
					critsBelong.add(crit);
	//				System.out.println("kriterie " + crit);
	//				System.out.println(crit.criterionCombos);			
				}
				//this if-sentence finds the criterion with be most acceptable rooms and therefore how many iterations we need
				if (crit.possibleRooms.size() > maxRes) {
					maxRes = crit.possibleRooms.size();

				}
			}	
			size++;
		}
	}
	
	
	//Possible Idea: make list of list with criterias combined so we can afford som tumbles in the arraylists ListOfLists and Critsbelong
	
	public static void delegateRooms(ArrayList<ArrayList<Room>> listOfCritMatches) throws SQLException {
		noRooms.clear();
		noRooms.addAll(Database.extractDuplicates(critsBelong, listOfCritMatches));
		System.out.println("duplicates extracted, no rooms: ");
		System.out.println(noRooms);
		System.out.println("size of noRooms: " + noRooms.size());
		System.out.println("size of listOfLists: " + listOfLists.size());
		for (int i = 0; i < listOfCritMatches.size(); i++ ) {
			if (listOfCritMatches.get(i).isEmpty()) {
				noRooms.add(critsBelong.get(i));
	//			System.out.println("no rooms " + noRooms);
			}
			else {	
				Combo com = new Combo(critsBelong.get(i), (listOfCritMatches.get(i)).get(0));
				combos.add(com);
				Room room = (listOfCritMatches.get(i).get(0)); //this one is given somewhere
	//			System.out.println("added" +  (listOfLists.get(i)));
				for (ArrayList<Room> list : listOfCritMatches) { //removes the room as a possibility elsewhere
					Database.removeEqualRoom(room.getName(), list);
					
				}
			}
		}
	}
	
	public static void printlistOfLists() {
		System.out.println(listOfLists.size());
		for (int i = 0; i < listOfLists.size(); i++) {
				System.out.println("Crit "+ i + ": " + critsBelong.get(i).getPersonName() + " Subject : " + critsBelong.get(i).getSubject() + "Mulige rom: " +listOfLists.get(i).size());
			System.out.println(listOfLists.get(i));
		}
	}
	
	
	
	
	public void assignCombosToTimeTable(int hours, int day) throws SQLException {
		int plus;
		for (Combo combo : combos) {
			if (combo.getCrit().getHours() == 1) {
				 plus = 1;
			}
			else { plus = 2;}
			Timetable.bookClassforSemester(combo.getCrit().getPersonName(), combo.getRoom().getName(), combo.getCrit().getSubject(), day, 8+hours, 8+hours+plus);
			System.out.println("Combo: " + combo + " has been written down in a timetable for day " + day + ", and " + (8+hours) + "'o clock." );
			combo.getCrit().removeBookedHours();
			if (combo.getCrit().getHours() > 0) {
				noRooms.add(combo.getCrit());
				System.out.println("added " + combo + "bc it it has " + combo.getCrit().getHours()  + " hours left.");
			}

	}
	}
	
	public static void main(String[] args) throws SQLException {
		Database.connect();
		AssignRooms test = new AssignRooms();
		test.AssignAllRooms();
		Database.disconnect();
		/*Room testRom = listOfLists.get(1).get(1);
		System.out.println(testRom);
		listOfLists.get(1).remove(testRom);
		System.out.println(listOfLists);*/
		
	}
	//end tag
}
