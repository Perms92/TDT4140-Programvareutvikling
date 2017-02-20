package RooMe;

public class Main {
	
	public void init(){
		RoomList roomList = new RoomList("svada");		
	}
	
	public void start(){
		Person person = new Person();
		System.out.println(person);
	}
	
	public static void main(String[] args) {
		Main program = new Main();
		program.init();
		program.start();
		
	}
	
}
