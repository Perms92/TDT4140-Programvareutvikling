package RooME;

public class Person {
	
	private String firstName, lastName;
	private int personId;
	
	public Person(String fistName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + "" + lastName;
	}

}
