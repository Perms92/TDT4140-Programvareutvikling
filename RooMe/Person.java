package RooMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {

	private String firstName, lastName, proffesion;
	private int personId;
	static List<Integer> personIdList = new ArrayList<Integer>();
	
	public Person() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter your first name: ");
		String firstName = reader.nextLine();
		System.out.println(firstName);
		System.out.println("Enter your last name: ");
		String lastName = reader.nextLine();
		System.out.println(lastName);
		System.out.println("Enter your proffesion: ");
		String proffesion = reader.nextLine();
		System.out.println(proffesion);
		this.firstName = firstName;
		this.lastName = lastName;
		this.proffesion = proffesion;
		this.personId = compareId();
		reader.close();
	}

	public int compareId() {
		int x = (int) (Math.random() * 100000 + 1); // Tilfeldig tall i [1, ..., 100000]
		while (personIdList.contains(x)){
			x = (int) (Math.random() * 900000 + 1); // Tilfeldig tall i [1, ..., 100000]
		}
		personIdList.add(x);
		return x;

	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public String getProffesion() {
		return proffesion;
	}
	
	public int getPersonId() {
		return personId;
	}

	public String toString() {
		return "Name: " + getName() + "\nProffesion: " 
	+ getProffesion() + "\nPerson ID: " + personId;
	}

	public static void main(String[] args) {
		Person Per = new Person();
		System.out.println(Per.toString());
		Person Ola = new Person();
		System.out.println(Ola.toString());
		System.out.println(personIdList);
	}
}
