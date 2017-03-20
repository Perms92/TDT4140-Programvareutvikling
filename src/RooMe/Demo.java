package RooMe;

public class Demo {

	public Demo() {
		System.out.println("Dette er en demo av programmet v�rt");
		System.out.println("F�rst tar vi input fra brukeren");
		RoomCriteria criteria = new RoomCriteria();
		
		//initializing a database to search in
		Database database = new Database("Realfagsbygget");
		
		System.out.println("Dette er rommene som vi skal s�ke gjennom");
		database.IterateList();
		
		//doing a search
		SearchForRoom search = new SearchForRoom(database, criteria.getStudentNumbers(), criteria.isProjector(), criteria.isBlackBoard(), criteria.isWhiteBoard());
		System.out.println("Til slutt f�r vi alle de aktuelle rommene");
		search.IterateList();
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
	}
}
