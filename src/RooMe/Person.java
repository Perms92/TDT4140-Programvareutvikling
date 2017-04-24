package RooMe;

import java.sql.*;
import java.util.ArrayList;

import Database.Database;

public class Person {
	
	private String Name;
	private boolean Employed;
	private ArrayList<Timetable> timeTables = new ArrayList<Timetable>();
	
	
	
	
	
	
	public ArrayList<Timetable> getTimeTables() {
		return timeTables;
	}

	public void setTimeTables(ArrayList<Timetable> timeTables) {
		this.timeTables = timeTables;
	}

	public Person(String name, Boolean lecturer) throws SQLException {
		setName(name);
		setEmployed(lecturer);
		addPerson();
		for (int day = 1; day<6;  day++) {
			Timetable oneDay = new Timetable(name, null, day);
			oneDay.addTimetable();
			timeTables.add(oneDay);
		}
		}
	
	
	public void addPerson() throws SQLException {
		String sql = "INSERT INTO thblaauw_tdt4145database.Person\n"
				+ "VALUES('"+getName()+"')";
		Database.sment.executeUpdate(sql);
	}
	
	public static void deletePerson(String name) throws SQLException {
		String sql = "DELETE FROM thblaauw_tdt4145database.Person\n"
				+ "WHERE Person.Name = '" +name+ "'";
		String sql2 = "DELETE FROM thblaauw_tdt4145database.TimeTable\n"
				+ "WHERE TimeTable.Person = '" +name+ "'";
		Database.sment.executeUpdate(sql);
		Database.sment.executeUpdate(sql2);
	}
	
	//Just a validation-method
	public static String getPerson(String name) throws SQLException {
		String sql = "SELECT * FROM thblaauw_tdt4145database.Person\n"
				+ "WHERE Person.Name = '" +name+ "'";
		Database.rs = Database.sment.executeQuery(sql);
		if (Database.rs.next()) {
			return Database.rs.getString(1);
		}
		return null;
		
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public boolean isEmployed() {
		return Employed;
	}

	public void setEmployed(boolean employed) {
		Employed = employed;
	}


	

	public static void main(String[] args) throws SQLException {
		/*
		Person André = new Person("Kristian tre", true);
		Person Kristian = new Person("Kristian to", true);
		Person KristianFem = new Person("Kristian fem", true);
		*/
	}

}
