package RooMe;

public class Room{

	private int capacity;
	private boolean projector;
	private boolean blackboard;
	private boolean whiteboard;
	private String name;
	private int roomID;
	
	protected Room(String name, int capacity, boolean projector, boolean blackboard, boolean whiteboard) {
		setSpace(capacity);
		setProjector(projector);
		setBlackboard(blackboard);
		setWhiteboard(whiteboard);
		setName(name);
	}
	
	public int getRoomID() {
		return roomID;
	}
	protected void setRoomID(int ID) {
		this.roomID = ID;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public int getSpace() {
		return capacity;
	}
	private void setSpace(int space) {
		this.capacity = space;
	}
	public boolean isProjector() {
		return projector;
	}
	private void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean isBlackboard() {
		return blackboard;
	}
	private void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}
	public boolean isWhiteboard() {
		return whiteboard;
	}
	private void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;

	}

	
	
	@Override 
	public String toString(){
		return "Name: " + name + "\t" + capacity + "\t" + projector + "\t" + whiteboard + "\t" + blackboard  + "\t";
	}
/*
	@Override
	public String toString() {
		return name + " has room for " + space + " persons, " + toEnglish(projector) + " projector, " 
		+ toEnglish(blackboard) + " blackboard, " + toEnglish(whiteboard) + " whiteboard.\n" + expSentence() +".";
	}
*/	
	
	
	/*
	public static void main(String[] args) {
		Room test = new Room("Test1", 100, true, false, true);
		System.out.println(test.isProjector());
		System.out.println(test);
		System.out.println(test.roomID);
		System.out.println(test.getRoomID());
	}
*/
}
