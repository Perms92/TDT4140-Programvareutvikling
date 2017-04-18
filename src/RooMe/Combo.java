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

	@Override
	public String toString() {
		return "Combo [name=" + crit.getPersonName() + ", subject=" + crit.getFag() + ", has been assigned room=" + room.getName() + "] \n";
	}
	
	
}
