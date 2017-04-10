package RooMe;
import java.sql.*;
import Database.Database;

public class Timetable {

	public Person Person;
	public Room Room;
	
	public Timetable() {
		setPerson(null);
		setRoom(null);
	}
	
	
	public Person getPerson() {
		return Person;
	}
	public void setPerson(Person Person) {
		this.Person = Person;
	}
	public Room getScheme() {
		return Room;
	}
	public void setRoom(Room Room) {
		this.Room = Room;
	}


	public void checkSingularity() throws IllegalStateException {
		if (Person!=null && Room!=null)
			throw new IllegalStateException("The timetable is either for a Person or a Room, not both!");
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timetable testtabell = new Timetable();
		Person ække = new Person();
		testtabell.setPerson(ække);
		System.out.println("greit nok");
		testtabell.checkSingularity();
		Room Soverom = new Room("Test1", 100, true, false, true);
		testtabell.setRoom(Soverom);
		testtabell.checkSingularity();
		System.out.println("kommer dette?");
	}

}
