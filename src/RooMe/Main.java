package RooMe;

import Database.Database;
import GUI.View;

public class Main {

	public Main() {
		Database.connect();
		View view = new View();
	}
}
