package OldCode;

import java.util.ArrayList;

import RooMe.RoomCriteria;

public class ListOfCriteria {
	
	//static ListOfCriteria list = new ListOfCriteria();
	static ArrayList<RoomCriteria> criteriaList = new ArrayList<RoomCriteria>();
	
	public ArrayList<RoomCriteria> addCriteria(RoomCriteria criteria){
		criteriaList.add(criteria);
		return criteriaList;
	}
	
	public RoomCriteria getCriteria(int index){
		return criteriaList.get(index);
	}
	
	/*
	public static void main(String[] args) {
		RoomCriteria crit = new RoomCriteria();
		list.addCriteria(crit);
		System.out.println(((criteriaList).get(0)).toString());
		
	}
	*/
}
