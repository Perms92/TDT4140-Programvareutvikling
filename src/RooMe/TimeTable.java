package RooMe;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TimeTable {

	static List<String> days = Arrays.asList("mandag", "tirsdag", "onsdag", "torsdag", "fredag");
	static List<Integer> periods = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	
	public TimeTable(){
		for (String day : days){
			System.out.println(day);
			for (Integer period : periods){
				System.out.println(period);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(days);
//		TimeTable timetable = new TimeTable();
	}

}
