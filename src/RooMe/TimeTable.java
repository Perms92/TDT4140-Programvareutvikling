package RooMe;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {

	private static ArrayList<String> times = new ArrayList<>();
	private static ArrayList<String> days = new ArrayList<>();
	private static ArrayList<String> lectureTime = new ArrayList<>();
	
	
	
	public TimeTable(){
		ArrayList<String> timetable = createTimetable();
	}
	
	//different subjects with the same professor cannot be active at the same time
	//timetable should be monday - friday, 08:15 - 20:00
	
	public static ArrayList<String> daysList() {
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		return days;
	}
	
	public static ArrayList timeList() {
		times.add("08:15 - 09:00");
		times.add("09:15 - 10:00");
		times.add("10:15 - 11:00");
		times.add("11:15 - 12:00");
		times.add("12:15 - 13:00");
		times.add("13:15 - 14:00");
		times.add("14:15 - 15:00");
		times.add("15:15 - 16:00");
		times.add("16:15 - 17:00");
		times.add("17:15 - 18:00");
		times.add("18:15 - 19:00");
		times.add("19:15 - 20:00");
		return times;
	}
	
	public static ArrayList<String> createTimetable() {
		ArrayList time = timeList();
		ArrayList days = daysList();
		
		for (Object day : days) {
			for (Object t : time) {
				String lecturetime;
				//System.out.println(day + " : " + t);
				lecturetime = day + " : " + t;
				lectureTime.add("\n" + lecturetime);
			}
		}
		return lectureTime;
	}
	
	public String toString() {
		return "" + lectureTime;
	}
	
	public static ArrayList<String> getLectureTime() {
		return lectureTime;
	}
	
	
	public static void main(String[] args) {
		createTimetable();
		System.out.println(getLectureTime());
	}
}
