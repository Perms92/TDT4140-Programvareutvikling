package RooMe;

public class Room{

	private int space;
	private boolean projector;
	private boolean experimentable;
	private boolean blackboard;
	private boolean whiteboard;
	
	
	
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
	
	public Room(int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard) {
		this.space = space;
		this.projector = projector;
		this.experimentable = experimentable;
		this.blackboard = blackboard;
		this.whiteboard = whiteboard;
	}
	
	
	
	

}
