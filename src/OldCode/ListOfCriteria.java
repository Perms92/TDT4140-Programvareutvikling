package OldCode;

import java.util.ArrayList;

public class ListOfCriteria {
	
	//static ListOfCriteria list = new ListOfCriteria();
	public static ArrayList<Criterion> criteriaList = new ArrayList<Criterion>();
	
	public static ArrayList<Criterion> addCriteria(Criterion criteria){
		criteriaList.add(criteria);
		return criteriaList;
	}
	
	public Criterion getCriteria(int index){
		return criteriaList.get(index);
	}
	
	public static void makeCrits() {
		Criterion crit = new Criterion("Kristian", 80, false, false, true);
		addCriteria(crit);
		Criterion crit2 = new Criterion("Trym",  40, true, false, false);
		addCriteria(crit2);
		Criterion crit3 = new Criterion("Creztian",  100, false, true, false);
		addCriteria(crit3);
		Criterion crit4 = new Criterion("Perms",  75, false, false, true);
		addCriteria(crit4);
	}

	/*
	public static void main(String[] args) {
		makeCrits();
	//	System.out.println(((criteriaList).get(0)).toString());
		for (Criterion crit : criteriaList) {
			System.out.println(crit.isProjector());
		}
	
	}
	*/
}
