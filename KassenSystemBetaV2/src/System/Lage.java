package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import resource.ResourceLoader;

public class Lage {

	public static List<Ware> lagelist =new LinkedList<Ware>();
	
	public static String listToString(List<?> list) {
	    String result = "";
	    for (int i = 0; i < list.size(); i++) {
	        result += "Id="+(i+1)+" " + list.get(i);
	        
	    }return result;
	}
	
	public static void AddWare(Connection c,String name,int menge,int price) throws SQLException {
		String sql = "INSERT INTO myWare (name, menge, price) VALUES (?, ?, ?)";

		try (PreparedStatement stm = c.prepareStatement(sql)) {
			
			stm.setString(1, name);
			stm.setInt(2, menge);
			stm.setDouble(3, price);
			stm.executeUpdate();
		}
	}
	public static void deleteWare(Connection c,int id) throws SQLException {
		String sql = "DELETE FROM myWare WHERE id = ?";

		try (PreparedStatement stm = c.prepareStatement(sql)) {
			stm.setInt(1,id);
			stm.executeUpdate();
		}
	}
	
	
	
	public static Connection getConnectionInMemoryDatabase() throws SQLException {
		String url = "jdbc:derby:memory:myDerby;create=true";
		return DriverManager.getConnection(url);
	}

	public static void createTable(Connection c) throws SQLException {

		try (Statement stm = c.createStatement()) {
			String sql = ResourceLoader.loadText("create_table_myWare.sql");

			stm.execute(sql);

//			System.out.println("Tabelle wurde erzeugt");
		} catch (SQLException e) {
			if (e.getSQLState().equals("X0Y32")) {
				System.out.println("table exists");
			} else {
				throw e;
			}
		}
	}
	
	public static void fillTable(Connection c) throws SQLException {
		String sql = "INSERT INTO myWare (name, menge, price) VALUES (?, ?, ?)";

		try (PreparedStatement stm = c.prepareStatement(sql)) {
			
			stm.setString(1, "Kaffee");
			stm.setInt(2, 10);
			stm.setDouble(3, 8);
			stm.executeUpdate();
			
			stm.setString(1, "Shamppo");
			stm.setInt(2, 15);
			stm.setDouble(3, 4);
			stm.executeUpdate();

			stm.setString(1, "Pepsi");
			stm.setInt(2, 100);
			stm.setDouble(3, 1.5);
			stm.executeUpdate();

			stm.setString(1, "Tee");
			stm.setInt(2, 50);
			stm.setInt(3, 3);
			stm.executeUpdate();

			stm.setString(1, "Bier");
			stm.setInt(2, 77);
			stm.setDouble(3, 1.5);
			stm.executeUpdate();
//			System.out.println("Einträge erstellt");
		}
	}
	
	
	public static void loadLage(Connection c) {
		try (Statement stm = c.createStatement()) {
			stm.execute("SELECT * FROM myWare");
			try (ResultSet res = stm.getResultSet()) {
//				System.out.printf(" id | %12s | %12s | %12s %n", "name","mange", "price");
				while (res.next()) {
//					System.out.printf("%3d | %12s | %12d | %12.2f %n", res.getInt(1), res.getString(2),
//							res.getInt(3), res.getDouble("price"));
					lagelist.add(new Ware(res.getString(2), res.getInt(3), res.getDouble("price")));
				}
			}
		} catch (SQLException e) {
		}
	}
	public static void printLage(Connection c) {
		try (Statement stm = c.createStatement()) {
			stm.execute("SELECT * FROM myWare");
			try (ResultSet res = stm.getResultSet()) {
				System.out.printf(" id | %12s | %12s | %12s %n", "name","mange", "price");
				while (res.next()) {
					System.out.printf("%3d | %12s | %12d | %12.2f %n", res.getInt(1), res.getString(2),
							res.getInt(3), res.getDouble("price"));
				}
			}
		} catch (SQLException e) {
		}
	}


	
//	public static void main(String[] args) {
//
//		try (Connection c = getConnectionInMemoryDatabase()) {
////			System.out.println("Verbindung Hergestellt");
//			createTable(c);
//			fillTable(c);
//			printLage(c);
////			deleteWare(c, 1);
////			System.out.println("-----");
////			printLage(c);
////			System.out.println("-----");
////			selectUndDeleteVonMenge(c, 2, 3, 1);
//			System.out.println(lagelist.toString());
////			lagelist.stream().forEach(System.out::println);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public static void selectUndDeleteVonMenge(Connection c,int id,int menge,int price) throws SQLException {
//	String sql1 = "SELECT id= ? FROM myWare ";
//	String sql2 = "DELETE FROM myWare WHERE menge = ?";
//
//	try (PreparedStatement stm1 = c.prepareStatement(sql1);
//			PreparedStatement stm2 = c.prepareStatement(sql2)) {
//		stm1.setInt(1,id);
//		stm1.execute();
//		ResultSet res =stm1.getResultSet();
//		while (res.next()) {
//		stm2.setInt(1,res.getInt(3)-menge);
//		}
//		stm2.executeUpdate();
//
//	}
//}
}


	
