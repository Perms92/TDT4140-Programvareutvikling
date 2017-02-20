package RooMe;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public void init(){
		RoomList roomList = new RoomList("svada");
	}
	
	public void start(){
		Person person = new Person();
		System.out.println(person);
		Person person2 = new Person();
		System.out.println(person2);
		Person person3 = new Person();
		System.out.println(person3);
		System.out.println(Person.personIdList);
		System.out.println(Person.personList);
	}
	
	public static void main(String[] args) {
		Main program = new Main();
		program.init();
		program.start();
		
	}
	
}
