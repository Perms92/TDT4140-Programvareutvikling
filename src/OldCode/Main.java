package OldCode;

import RooMe.Person;
import RooMe.Room;
import RooMe.RoomList;

public class Main {
	
	public RoomList roomList;
	public TimeTable timetable;
	
	public void init(){
		this.roomList = new RoomList("svada");
		timetable = new TimeTable();
		Room test = new Room("Test", 100, true, false, true);
		roomList.addRoom(test);
	}
	
	public void start(){

		Person lektor = new Person();
		Room rom = new Room("Rom 1", 30, true, true,false);

		Person person = new Person();
		System.out.println(person);
		RoomRequest req = new RoomRequest(person, 1300, "data" );

		for (String day : timetable.days){
			if (timetable.periods.contains(req.time)){
				System.out.println(person.firstName + " " + person.lastName + " have now booked: " + 
						"Test, " + "at time: " + req.time + ", for the subject: " + req.subject );
			}
			return;
			
		}
	}
	
	public static void main(String[] args) {
		Main program = new Main();
		program.init();
		program.start();
		
	}
	
}
