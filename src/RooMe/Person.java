package RooMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {

	public String firstName, lastName, proffesion;
	private int personId;
	public static List<Integer> personIdList = new ArrayList<Integer>();
	public static ArrayList<Person> personList = new ArrayList<Person>();
	
	Scanner reader = new Scanner(System.in);
	
	public Person() {
		System.out.println("Enter your first name: ");
		String firstName = reader.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = reader.nextLine();
		System.out.println("Enter your proffesion (student/lecturer): ");
		String proffesion = reader.nextLine();
		
		firstName = checkName(firstName);
		this.firstName = firstName;
		lastName = checkName(lastName);
		this.lastName = lastName;
		proffesion = checkProffesion(proffesion);
		this.proffesion = proffesion;
		this.personId = compareId();
		Person.personList.add(this);
	}
	
	public String checkName(String name) {
		name.toLowerCase();
	    char[] chars = name.toCharArray();
	    try {
		    for (char c : chars) {
		        if((!Character.isLetter(c) && !Character.isDefined(' ')) || Character.isDigit(c)) {
		        	throw new IllegalArgumentException();
		        }
		    }
	    } catch (Exception e) {
	    	System.out.println("Only letters in your name, test exception");
	    	name = name.replace("0", "");
	    	name = name.replace("1", "");
	    	name = name.replace("2", "");
	    	name = name.replace("3", "");
	    	name = name.replace("4", "");
	    	name = name.replace("5", "");
	    	name = name.replace("6", "");
	    	name = name.replace("7", "");
	    	name = name.replace("8", "");
	    	name = name.replace("9", "");
	    }
	    return name;
	}
	
	public String checkProffesion(String proffesion) {
	    char[] chars = proffesion.toCharArray();
	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	        	throw new IllegalArgumentException("Only letters in your proffesion");
	        }
	    }
	    if (proffesion.toLowerCase().matches("student") || proffesion.toLowerCase().matches("lecturer")){
	    	return proffesion;
	    } else {
	    	throw new IllegalArgumentException("Wrong proffesion, must be student or lecturer");
	    }
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
		return "\nName: " + getName() + ", Proffesion: " 
	+ getProffesion() + ", Person ID: " + personId;
	}

	public static void main(String[] args) {
		Person person = new Person();
		//Person person2 = new Person();
		System.out.println(personIdList);
		System.out.println(personList);
	}
	
}
