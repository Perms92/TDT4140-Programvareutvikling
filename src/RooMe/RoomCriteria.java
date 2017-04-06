package RooMe;

public class RoomCriteria {
	
	private boolean projector, blackBoard, whiteBoard, experimentTable;
	private int studentNumbers;
		
	public RoomCriteria(int studentNumbers, boolean projector, boolean blackBoard, boolean whiteBoard, boolean experimentTable) {
		this.studentNumbers = studentNumbers;
		this.projector = projector;
		this.blackBoard = blackBoard;
		this.whiteBoard = whiteBoard;
		this.experimentTable = experimentTable;
	}

	void setProjector(boolean projector) {
		this.projector = projector;
	}

	void setBlackBoard(boolean blackBoard) {
		this.blackBoard = blackBoard;
	}

	void setWhiteBoard(boolean whiteBoard) {
		this.whiteBoard = whiteBoard;
	}

	void setExperimentTable(boolean experimentTable) {
		this.experimentTable = experimentTable;
	}

	void setStudentNumbers(int studentNumbers) {
		this.studentNumbers = studentNumbers;
	}

	public String toString() {
		return "Number of students: " + studentNumbers
				+ "\nProjector: " + projector
				+ "\nBlackboard: " + blackBoard
				+ "\nWhiteboard: " + whiteBoard
				+ "\nExperiment table: " + experimentTable;
	}
	

	public boolean isProjector() {
		return projector;
	}

	public boolean isBlackBoard() {
		return blackBoard;
	}

	public boolean isWhiteBoard() {
		return whiteBoard;
	}

	public boolean isExperimentTable() {
		return experimentTable;
	}

	public int getStudentNumbers() {
		return studentNumbers;
	}
}
