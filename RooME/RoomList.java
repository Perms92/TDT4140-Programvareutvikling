package RooME;

public class RoomList {

	private static int roomCapacity;
	private static String roomName;
	private boolean projector;
	private boolean blackboard;
	
	public static void roomInfo(){
		System.out.println(roomName + " can have " + roomCapacity + " people");
	}
	
}
