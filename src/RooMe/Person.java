package RooMe;

import java.sql.*;
import java.util.ArrayList;

import Database.Database;

public class Person {
	
	private String Name;
	private boolean Employed;
	//aktuelt?
	private ArrayList<String> Subjects = new ArrayList<String>();
	//nja
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
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.Person\n"
				+ "VALUES('"+getName()+"')";
		Database.sment.executeUpdate(sql);
		Database.disconnect();
	}
	
	public void createTimeTables() throws SQLException {
		Database.connect();
		String sql = "INSERT INTO thblaauw_tdt4145database.Person\n"
				+ "VALUES('"+getName()+"')";
		Database.sment.executeUpdate(sql);
		Database.disconnect();
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

	public ArrayList<String> getSubjects() {
		return Subjects;
	}

	public void setSubjects(ArrayList<String> subjects) {
		this.Subjects = subjects;
	}
	

	public static void main(String[] args) throws SQLException {
		Person eirik = new Person("Eirik", true);
		/*
		Person André = new Person("Kristian tre", true);
		Person Kristian = new Person("Kristian to", true);
		Person KristianFem = new Person("Kristian fem", true);
		*/
	}

}
