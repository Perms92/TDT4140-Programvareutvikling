package OldCode;

import java.sql.SQLException;

import Database.Database;

public class SearchCriteriaDB {

	
	
	public static void getRoomCriterias() {
		Database.connect();
		try {
			Database.rs = Database.sment.executeQuery("select * from thblaauw_tdt4145database.Criterias");
			System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s","Foreleser", "Fag", "Capacity", "Projector", "Blackboard", "Whiteboard"+"\n");
			System.out.println("---------------------------------------------------------------------------------------------");
			while (Database.rs.next()){
				System.out.printf("%-20s %-9s %-10s %-11s %-12s %-12s"
						+ "", Database.rs.getString(1),
									Database.rs.getString(2),
									Database.rs.getInt(3),
									Database.rs.getBoolean(4),
									Database.rs.getBoolean(5),
									Database.rs.getBoolean(6));
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.disconnect(); 
	}
}
