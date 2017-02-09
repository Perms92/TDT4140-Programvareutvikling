package RooME;

public class Room {

	private static int roomCapacity;
	private static String roomName;
	private boolean projector;
	private boolean blackboard;
	
	public static void roomInfo(){
		System.out.println(roomName + " can have " + roomCapacity + " people");
	}
	
}
