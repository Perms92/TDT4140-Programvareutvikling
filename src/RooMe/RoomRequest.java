package RooMe;

public class RoomRequest {

	public int reqID;
	public int personID;
	
	public RoomRequest(Person person, int tid, String subject){
		personID = person.getPersonId();
				
	}
	
	private void generateReqID(){
		
	}
	
	public static void main(String[] args) {
		
	}

}
