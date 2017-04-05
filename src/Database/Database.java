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
	
	
	
	
	/*public static void printOvelserInOkt(Date date){
		Database.connect();
		try {
			rs=sment.executeQuery("select Navn from oyvorsh_treningsdatabase.Ovelse as ove,"
					+ " oyvorsh_treningsdatabase.OktHarOvelse as harOve"
					+ " WHERE harOve.oID = ove.oID"
					+ " AND harOve.Dato = '" + date+"'");
			System.out.println("Ovelser");
			System.out.println("-------");
			while (rs.next()){
				System.out.println(rs.getString(1));
			}
			System.out.println(); //print new line
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.disconnect();
	}
	
	public static void printOvelser(){
		Database.connect();
		try {
			rs=sment.executeQuery("select * from oyvorsh_treningsdatabase.Ovelse");
			System.out.println("OvelsesID  Ovelse");
			System.out.println("-------------------");
			while (rs.next()){
				System.out.println(rs.getString(1)+"          "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Database.disconnect();
	}
	
	public static void printHistory(String fraTid, String tilTid){
		Database.connect();
		String sql=" ";
		try {
			rs=sment.executeQuery(sql);
			System.out.println("Treningsøkter i perioden: "+fraTid+tilTid+":");
			System.out.println("Dato  Varighet  Øvelser");
			while (rs.next()){
				System.out.println(rs.getString(1)+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ResultSet getRs() {
		return rs;
	}
	

	public static void setRs(ResultSet rs) {
		Database.rs = rs;
	}
	
	
	public static void addGoal(Goal goal) throws SQLException{
		Database.connect();
		String sql = "INSERT INTO oyvorsh_treningsdatabase.Maal\n"
				+ "(oID, Beskrivelse, fraDato, tilDato)\n"
				+ "VALUES(?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, goal.getoID());
		statement.setString(2, goal.getBeskrivelse());
		statement.setDate(3, goal.getTilDato());
		statement.setDate(4, goal.getFraDato());
		statement.executeUpdate();
		Database.disconnect();
	}

	public static void addTreningsokt(Treningsokt treningsokt) throws SQLException {
		Database.connect();
		String sql = "INSERT INTO oyvorsh_treningsdatabase.Treningsokt\n"
				+ "(Dato, Tidspunkt, Varighet, Egenvurdering, Fysisk_Form, Notat)\n"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setDate(1, treningsokt.getDato());
		statement.setString(2, treningsokt.getTidspunkt());
		statement.setString(3, treningsokt.getVarighet());
		statement.setString(4, treningsokt.getEgenvurdering());
		statement.setString(5, treningsokt.getFysiskForm());
		statement.setString(6, treningsokt.getNotat());
		
		statement.executeUpdate();
		Database.disconnect();
		
	}
	
	public static void addOvelseTilOkt(int oID, Treningsokt treningsokt) throws SQLException{
		Database.connect();
		String sql = "INSERT INTO oyvorsh_treningsdatabase.OktHarOvelse\n"
				+ "(Dato, oID)\n"
				+ "VALUES(?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setDate(1, treningsokt.getDato());
		statement.setInt(2, oID);
		
		statement.executeUpdate();
		
		Database.disconnect();
	}
	

	public static void deleteOktFraDato(Date dato) {
		Database.connect();
		try {
		sment.executeUpdate("DELETE FROM oyvorsh_treningsdatabase.Treningsokt"
				+ " WHERE Treningsokt.Dato ='"+ dato+"'");
		sment.executeUpdate("DELETE FROM oyvorsh_treningsdatabase.OktHarOvelse"
				+ " WHERE OktHarOvelse.Dato = '" + dato +"'");
		System.out.println("Øktene fra "+dato+" er slettet\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Database.disconnect();
		}

	// Finds the best date <3
	public static String getBestDate() {
		Database.connect();
		
		int best = 0;
		Date bDate = Date.valueOf("2000-01-01");		
		// Fetch ranking-list
		try { rs=sment.executeQuery("select Dato, Egenvurdering from oyvorsh_treningsdatabase.Treningsokt");
			while (rs.next()){ 
				if (Integer.valueOf(rs.getString(2)) > best) { 
					best = Integer.valueOf(rs.getString(2)); 
					bDate = Date.valueOf(rs.getString(1)); 
					} } }
		catch (SQLException e) { System.out.println("pikk"); e.printStackTrace(); }
		Database.disconnect();	
		return "Din beste økt var " + bDate + " , og ble rangert til " + best + " på skala fra 1-10. "; 
	}*/
	

}
