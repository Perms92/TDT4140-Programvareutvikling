package RooMe;

public class Combo {
/*
 * Algoritmelogikk
 * For alle kriterier med bare 1 rom som matcher - de får dette rommet
 * For alle rom som har flere matcher inkludert dette rommet, fjernes dette rommet som mulighet
 * Hvis de da har bare 1 rom igjen, får de dette.
 * - REPETER -
 * Hvis flere mulige, velg rommet som dekker flest kriterier men ikke noe ekstra
 */
	
	
	private RoomCriteria crit;
	private Room room;
	
	public Combo(RoomCriteria crit, Room room) {
		this.crit = crit;
		this.room = room;
	}
	
	

	public RoomCriteria getCrit() {
		return crit;
	}



	public void setCrit(RoomCriteria crit) {
		this.crit = crit;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
	}



	@Override
	public String toString() {
		return "Combo [name=" + crit.getPersonName() + ", subject=" + crit.getSubject() + ", has been assigned room=" + room.getName() + "] \n";
	}
	
	
}
