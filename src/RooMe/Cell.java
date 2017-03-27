package RooMe;

public class Cell {
	
	private String day;
	private String time;
	
	public Cell(String day, String time) {
		this.day = day;
		this.time = time;
	}
	
	public String isEmpty() {
		if (getCell() == null) {
			return "The room is availeble";
		}
		return "The room is occupied at that time";
	}
	
	public String getCell() {
		return "" + day + " " + time;
	}

	@Override
	public String toString() {
		return "" + day + " " + time;
	}
	
	public static void main(String[] args) {
		Cell[][] c1 = new Cell[10-12][14];
		System.out.println(c1);
	}
	
}
