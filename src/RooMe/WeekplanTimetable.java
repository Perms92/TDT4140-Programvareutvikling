package RooMe;

import java.util.ArrayList;

public class WeekplanTimetable {

	public WeekplanTimetable(){
		WeekplanTimetable timetable = new WeekplanTimetable();
	}
	
	//different subjects with the same professor cannot be active at the same time
	//timetable should be monday - friday, 08:15 - 20:00
	private static ArrayList days = new ArrayList<>();
	
	public static ArrayList daysList() {
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		return days;
	}
	
private static ArrayList time = new ArrayList<>();
	
	public static ArrayList timeList() {
		time.add("08:15 - 09:00");
		time.add("09:15 - 10:00");
		time.add("10:15 - 11:00");
		time.add("11:15 - 12:00");
		time.add("12:15 - 13:00");
		time.add("13:15 - 14:00");
		time.add("14:15 - 15:00");
		time.add("15:15 - 16:00");
		time.add("16:15 - 17:00");
		time.add("17:15 - 18:00");
		time.add("18:15 - 19:00");
		time.add("19:15 - 20:00");
		return time;
	}
	
	public static void createTimetable() {
		ArrayList time = timeList();
		ArrayList days = daysList();
		
		for (Object day : days) {
			for (Object t : time) {
				System.out.println(day + " : " + t);
			}
		}
	}
	
	public static void main(String[] args) {
		createTimetable();
	}
}
