package Database;
import java.sql.*;

public class Database {
	public static Connection conn=null;
	public static Statement sment=null;
	public static ResultSet rs=null;
	//ForBedreKode(FBK): Innkapsle attributtene og legg til getters
	public static Statement getStatement(){
		return sment;
	}
	public static void connect(){
		try {
			Database.conn=DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/thblaauw_tdt4145database?user=thblaauw_tdt4145&password=ey877fja");
			sment=conn.createStatement();
			System.out.println("Connection made");
		} catch (SQLException ex){
			System.out.println("SQLException: "+ex.getMessage());
		}
	}
	
	public static void disconnect(){
		try {
			Database.conn.close();
			System.out.println("Disconnected");
		} catch (SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		connect();
		disconnect();
	}
	
}
