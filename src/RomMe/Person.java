package RomMe;

public class Person {
	
	private String firstName, lastName;
	
	public Person(String fistName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getName() {
		return firstName + "" + lastName;
	}

}
