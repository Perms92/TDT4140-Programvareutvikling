package RooMe;

import java.util.Scanner;

public class RoomCriteria {
	
	private boolean projector, blackBoard;
	private boolean whiteBoard, experimentTable;
	private int studentNumbers;
	
	static Scanner reader = new Scanner(System.in);
	
	public RoomCriteria() {
		int number = setStudentNumber();
		this.studentNumbers = number;
		boolean projector = setProjector();
		this.projector = projector;
		boolean blackBoard = setBlackBoard();
		this.blackBoard = blackBoard;
		boolean whiteBoard = setWhiteBoard();
		this.whiteBoard = whiteBoard;
		boolean exTable = setExperimentTable();
		this.experimentTable = exTable;
	}
	
	public static int setStudentNumber() {
		System.out.println("How many students?");
		int number = reader.nextInt();
		return number;
	}

	public static boolean setProjector() {
		System.out.println("Do you need a projector? true/false");
		boolean projector = reader.nextBoolean();
		return projector;
	}
	
	public static boolean setBlackBoard() {
		System.out.println("Do you need a blackboard? true/false");
		boolean blackboard = reader.nextBoolean();
		return blackboard;
	}
	
	public static boolean setWhiteBoard() {
		System.out.println("Do you need a WhiteBoard? true/false");
		boolean WhiteBoard = reader.nextBoolean();
		return WhiteBoard;
	}
	
	public static boolean setExperimentTable() {
		System.out.println("Do you need an experiment table? true/false");
		boolean exTable = reader.nextBoolean();
		return exTable;
	}
	
	public String toString() {
		return "Number of students: " + studentNumbers
				+ "\nProjector: " + projector
				+ "\nBlackboard: " + blackBoard
				+ "\nWhiteboard: " + whiteBoard
				+ "\nExperiment table: " + experimentTable;
	}
	
	public static void main(String[] args) {
		RoomCriteria room1 = new RoomCriteria();
		System.out.println(room1.toString());
		
	}

}
