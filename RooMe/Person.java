package RooMe;


public class Person {
	
	private String firstName, lastName;
	private int personId;
	
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personId = 1;
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
