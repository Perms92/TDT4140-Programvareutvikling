package RooMEbeta;

public class Room {

	public String name;
	public int capacity;
	public boolean blackboard;
	public boolean projector;
	
	public Room (String name, int capacity, boolean blackboard, boolean projector) {
		this.name = name;
		this.capacity = capacity;
		this.blackboard = blackboard;
		this.projector = projector;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getCapacity() {
		return capacity;
	}

	void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	boolean isBlackboard() {
		return blackboard;
	}

	void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}

	boolean isProjector() {
		return projector;
	}

	void setProjector(boolean projector) {
		this.projector = projector;
	}
	
	
	
}
