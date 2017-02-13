package RooMe;

import java.util.ArrayList;

public class Person {
	
	private String firstName, lastName;
	private int personId;
	private ArrayList<Integer> list;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personId = personIdCounter();
	}
	
	public int personIdCounter() { // Denne funker ikke enda
		int id = (int) (Math.random() * 1000 + 1); // Tilfeldig tall i [1, ..., 100]
		if (list.contains(id)){
			this.personId = (int) (Math.random() * 1000 + 2); // Tilfeldig tall i [1, ..., 100]
			list.add(id);
			return id;
		} else {
			list.add(id);
			return personId;
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
		ArrayList<Integer> list = new ArrayList<>();
		Person Per = new Person("Per Morten", "Solheim");
		System.out.println(Per.toString());
		Person Ola = new Person("Ola", "Nordman");
		System.out.println(Ola.toString());
		System.out.println(Ola.getPersonId());
	}

}
