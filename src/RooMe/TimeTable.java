package RooMe;

import java.util.ArrayList;

public class TimeTable {

	private static ArrayList<Object> times = new ArrayList<>();
	private static ArrayList<Object> days = new ArrayList<>();
	
	private Cell[][] cells;
	
	public TimeTable(String time, String day){
		/*
		
		cells = new Cell[time][day];
		for (int i = 0; i < time.length(); i++) {
			String lectureTime = times[i];
			System.out.println(lectureTime);
			for (int j = 0; j < day.length(); j++) {
				String lectureDay = days[j];
				System.out.println(lectureDay);
				cells[i][j] = new Cell
			}
		}*/
	}
	
	//different subjects with the same professor cannot be active at the same time
	//timetable should be monday - friday, 08:15 - 20:00
	
	public static ArrayList daysList() {
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
		//createTimetable();
		System.out.println("Hello World");
	}
}
