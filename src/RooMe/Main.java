package RooMe;

public class Main {
	
	public void init(){
		RoomList roomList = new RoomList("svada");
	}
	
	public void start(){
		Person person = new Person();
		System.out.println(person);
		System.out.println(Person.personIdList);
		System.out.println(Person.personList);
		
	}
	
	public static void main(String[] args) {
		Main program = new Main();
		program.init();
		program.start();
		
	}
	
}
