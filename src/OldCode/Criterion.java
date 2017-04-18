package OldCode;

import java.util.ArrayList;

import RooMe.Room;

public class Criterion {

	public ArrayList<Room> criterionCombos = new ArrayList<Room>();

	private int capacity;
	private boolean projector;
	private boolean blackboard;
	private boolean hearingaid;
	private String name;
	
	protected Criterion(String name, int capacity, boolean projector, boolean blackboard, boolean hearingaid) {
		setName(name);
		setCapacity(capacity);
		setProjector(projector);
		setBlackboard(blackboard);
		setHearingaid(hearingaid);
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;

	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean isBlackboard() {
		return blackboard;
	}

	public void setBlackboard(boolean blackboard) {
		this.blackboard = blackboard;
	}

	public boolean isHearingaid() {
		return hearingaid;
	}

	public void setHearingaid(boolean hearingaid) {
		this.hearingaid = hearingaid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Criterion [name=" + name + ", capacity=" + capacity + ", projector=" + projector + ", blackboard=" + blackboard
				+ ", hearingaid=" + hearingaid + "]";// + "\n";
	}
	
	
}
