package RooMe;

import java.util.List;
import java.util.ArrayList;

public class RoomRequest {

	public int reqID;
	public int personID;
	public int priority;
	public int time;
	public String subject;
	public static ArrayList<RoomRequest> reqList;

	
	public RoomRequest(Person person, int tid, String subject){
		this.personID = person.getPersonId();
		setReqID();
		setTime(tid);
		setSubject(subject);
		setPriority();
	}

	//lage klasse for denne?	
	private void appendReq(RoomRequest r){
		reqList.add(r);
	}
	
	private void setReqID(){
		this.reqID = 1;
	}
	
	private void setTime(int tid){
		this.time = tid;
	}
	
	private void setSubject(String subject){
		this.subject = subject;
	}
	
	//maa gjores om til dynamisk, ikke statisk 1
	public void setPriority(){
		this.priority = 1;
	}
		
	
	private void generateReqID(){
		
	}
	
	public static void main(String[] args) {
		
	}

}
