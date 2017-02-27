package RooMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Hashtable;

public class Room{

	private int space;
	private boolean projector;
	private boolean experimentable;
	private boolean blackboard;
	private boolean whiteboard;
	private String name;
	private int roomID;
	
	public Room(String name, int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard) {
		this.space = space;
		this.projector = projector;
		this.experimentable = experimentable;
		this.blackboard = blackboard;
		this.whiteboard = whiteboard;
		this.name = name;
	}
	
	public static int getRoomID(Room room) {
		return room.roomID;
	}
	protected void setRoomID(int ID) {
		this.roomID = ID;
	}
<<<<<<< HEAD
	
=======

>>>>>>> 2001a9ee99c959f06e32be697a8d01b1204bf02d
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public int getSpace() {
		return space;
	}
	private void setSpace(int space) {
		this.space = space;
	}
	public boolean isProjector() {
		return projector;
	}
	private void setProjector(boolean projector) {
		this.projector = projector;
	}
	public boolean isExperimentable() {
		return experimentable;
	}
	
	private void setExperimentable(boolean experimentable) {
		this.experimentable = experimentable;
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
<<<<<<< HEAD
	}
	
	
	protected Room(String name, int space, boolean projector, boolean experimentable, boolean blackboard, boolean whiteboard) {
		setSpace(space);
		setProjector(projector);
		setExperimentable(experimentable);
		setBlackboard(blackboard);
		setWhiteboard(whiteboard);
		setName(name);
=======
>>>>>>> 2001a9ee99c959f06e32be697a8d01b1204bf02d
	}
	
	private String toEnglish(boolean value){
		if (value == true) {
		return "has a";
		}
		else return "does not have a";
	}
	private String expSentence(){
		if (experimentable == true) {
			return "It is possible to do experiments in this room";
		}
		else return "It is not possible to do experiments in this room"; 
		}
	
	@Override 
	public String toString(){
		return "name: " + name + " space: " + space + " people," + " projector: " + projector +  
				", blackboard: " + blackboard + ", whiteboard: " + whiteboard + ", experimentable: " + experimentable;
	}
/*
	@Override
	public String toString() {
		return name + " has room for " + space + " persons, " + toEnglish(projector) + " projector, " 
		+ toEnglish(blackboard) + " blackboard, " + toEnglish(whiteboard) + " whiteboard.\n" + expSentence() +".";
	}
*/	
	public static void main(String[] args) {
		Room test = new Room("Test1", 100, true, false, false, true);
		System.out.println(test);
		System.out.println(test.roomID);
		System.out.println(getRoomID(test));
	}

}
