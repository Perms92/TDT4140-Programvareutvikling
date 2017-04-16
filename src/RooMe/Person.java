package RooMe;

public class Person {
	
	private String Name;
	private String Position;
	
	
	
	public Person(String name, String position) {
		Name = name;
		Position = position;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		this.Position = position;
	}
	
	

}
