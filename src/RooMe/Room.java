package RooMe;

public class Room{

	private int space;
	private boolean projector;
	private boolean experimentable;
	private boolean blackboard;
	private boolean whiteboard;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpace() {
		return space;
	}
	public void setSpace(int space) {
		this.space = space;
	}
	public boolean isProjector() {
		return projector;
	}
	public void setProjector(boolean projector) {
		this.projector = projector;
	}
	public boolean isExperimentable() {
		return experimentable;
	}
	public void setExperimentable(boolean experimentable) {
		this.experimentable = experimentable;
	}
	public boolean isBlackboard() {
		return blackboard;
	}
	public void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}
	public boolean isWhiteboard() {
		return whiteboard;
	}
	public void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;
	}
	
	public Room(String name, int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard) {
		this.space = space;
		this.projector = projector;
		this.experimentable = experimentable;
		this.blackboard = blackboard;
		this.whiteboard = whiteboard;
		this.name = name;
	}
	

@Override
	public String toString() {
		return "Room [space=" + space + ", projector=" + projector + ", experimentable=" + experimentable
				+ ", blackboard=" + blackboard + ", whiteboard=" + whiteboard + ", name=" + name + "]";
	}

public static void main(String[] args) {
	Room test = new Room("Test1", 100, true, false, false, true);
	System.out.println(test);
}
	

}
