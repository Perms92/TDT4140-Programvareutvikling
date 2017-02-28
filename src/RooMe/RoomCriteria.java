package RooMe;

import java.util.Scanner;

public class RoomCriteria {
	
	private boolean projector, blackBoard;
	private boolean whiteBoard, experimentable;
	private int studentNumbers;
	
	static Scanner reader = new Scanner(System.in);
	
	private static int setStudentNumbers() {
		System.out.println("How many students?");
		int number = reader.nextInt();
		return number;
	}

	private boolean setProjector() {
		System.out.println("Do you need a projector? true/false");
		boolean projector = reader.nextBoolean();
		return projector;
	}
	
	private boolean setBlackBoard() {
		System.out.println("Do you need a blackboard? true/false");
		boolean blackboard = reader.nextBoolean();
		return blackboard;
	}
	
	private boolean setWhiteBoard() {
		System.out.println("Do you need a WhiteBoard? true/false");
		boolean WhiteBoard = reader.nextBoolean();
		return WhiteBoard;
	}
	
	private boolean setProjector() {
		System.out.println("Do you need a projector? true/false");
		boolean projector = reader.nextBoolean();
		return projector;
	}
	
	public static void main(String[] args) {
		int number = setStudentNumbers();
		System.out.println(number);

	}

}
