package RooMe;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String firstName, lastName;
	private int personId;
	private List<Integer> idList;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personId = personIdCounter();
	}
	
	public int personIdCounter() { // Denne funker ikke enda
		int id = checkIdList();
		System.out.println("ID: " + id);
		if (idList.contains(id)){
			return id;
		} else {
			return personId;
		}
	}
	
	public List checkIdList() {
		int id = (int) (Math.random() * 1000 + 1); // Tilfeldig tall i [1, ..., 1000]
		List<Integer> idList = new ArrayList<>();
		this.idList.add(id);
		if (this.idList.contains(id)) {
			
		}
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public int getPersonId() {
		return personId;
	}
	
	public String toString() {
		return "Name: " + getName() + "\nPerson ID: " + personId;
	}
	
	public static void main(String[] args) {
		Person Per = new Person("Per Morten", "Solheim");
		System.out.println(Per.toString());
		Person Ola = new Person("Ola", "Nordman");
		System.out.println(Ola.toString());
		System.out.println(Ola.getPersonId());
	}

}
