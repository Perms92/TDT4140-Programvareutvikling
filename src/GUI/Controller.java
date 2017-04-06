package GUI;

import java.time.LocalDate;
import java.time.LocalTime;
import RooMe.Database;
import RooMe.SearchForRoom;

public class Controller {
	
	//must make database outside functions to avoid duplicates
	static Database database = new Database("Test");
	
	public static SearchForRoom Search(Database database, int amount, boolean cb1, boolean cb2, boolean cb3) {
		SearchForRoom search = new SearchForRoom(database, amount, cb1, cb2, cb3);
		return search;
	}
	
	
	public static boolean validateAmount(String amount) {
		if ((amount).equals("")){
			return false;
		}
		else if (amount.matches("^[0-9]*$")) { 
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public static boolean checkValue(boolean isPressed){
		if(isPressed == true) {
			return true;
		}
		else {
			return false;
		}
	}
	

	public static boolean validateName(String name) {
		if(name.length() > 0) {
			return true;
		}
		else {
			return false;
		}

	}
	
	//none below used at the moment, from MMI
	public static boolean validateRoom(String room) {
		if (room.matches("[a-zA-Z]+[-][a-zA-Z]+\\s\\d+")) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean validateDate(LocalDate fromDate) {
		LocalDate today = LocalDate.now();
		try {
			if (fromDate.isAfter(today)) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

	public static boolean validateTime(String fromTime, String toTime) {
		//if fromTime is wrongly formatted
		if (!fromTime.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")) {
			return false;
		}
		//if toTime is wrongly formatted
		if (!toTime.matches("^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")) {
			return false;
		}

		//check if end after start
		LocalTime startTime = LocalTime.parse(fromTime);
		LocalTime endTime = LocalTime.parse(toTime);

		if (endTime.isAfter(startTime)) {
			//do stuff when its correct
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean validateRepetition(String repetition) {
		try {
			Integer.parseInt(repetition);

			return true;
		}
		catch (NumberFormatException e) {
		    return false;
		}
		catch (NullPointerException e) {
			return false;
		}
	}

	public static boolean validateEndDate(LocalDate endDate) {
		LocalDate today = LocalDate.now();
		try {
			if (endDate.isAfter(today)) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			return false;
		}
	}
}
