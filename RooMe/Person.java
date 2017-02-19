package RooMe;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String firstName, lastName;
	private int personId;
	List<Integer> personIdList = new ArrayList<Integer>();
	
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personId = compareId();
	}
	
	public int compareId() {
		int x = (int) (Math.random() * 100000 + 1); // Tilfeldig tall i [1, ..., 50]
		if (! personIdList.contains(x)){
			personIdList.add(x);
			return x;
		} else if (personIdList.contains(x)){
			x = (int) (Math.random() * 900000 + 1); // Tilfeldig tall i [1, ..., 50]
			personIdList.add(x);
			return x;
		} else {
			throw new IllegalArgumentException("Something went wrong"
					+ " with making your ID number, please try again");
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
		System.out.println(Per.getPersonId());
	}

}
