package portfolio.jdbc;

import java.sql.*;
import static java.lang.System.out;

public class JdbcExample {

	private static final String DBURL = "jdbc:oracle:thin:@10.220.1.239:1521/CLOUDDB.azerconnect.az";
	// public static final String DBURL = "jdbc:mysql://localhost:3306/DB_NAME";
	private static final String DBUSER = "dba_maintenance";
	private static final String DBPASS = "Dba%Ma!n7enance321";
	private static Connection con;

	private static void createConnection() {
		// step1 load the driver class - Tomcat needs this, we can omit it here
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Class.forName("com.mysql.jdbc.driver");

		// step2 create the connection object
		try {
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void retrieveResult() {
		try {

			// step3 create the statement object
			Statement stmt = con.createStatement();
			String sql = "select id, name from azer_test order by 1";
			ResultSet rs = stmt.executeQuery(sql);

			// Retrieving 2nd column name
			// ResultSetMetaData rsmd = rs.getMetaData();
			// String columnName = rsmd.getColumnName(2);
			// System.out.println("#####" + columnName + "#####");

			// int rc = stmt.executeUpdate(sql);
			// System.out.println(rc + " row(s) inserted");
			// here sql is update, delete or insert statements
			// and rc is the record count that affected by "sql"
			// 5rows deleted, 9rows updated so on.

			out.println("ID" + "\t" + "NAME"); // first column + <TAB> + second column
			while (rs.next()) {
				System.out.println("--------------------");
				// out.println(rs.getInt(1) + "\t-->\t" + rs.getString(2)); // firt column +
				// <TAB> +
				// second column
				out.println(rs.getInt("ID") + "\t" + rs.getString("NAME")); // firt column + <TAB> + second column
			}
			System.out.println("--------------------");

			// step5 close the connection object
			rs.close();
			stmt.close();

		} catch (

		Exception e) {
			out.println(e);
		}
	}

	private static void insertData(int id, String name) {
		try {

			// step3 create the statement object
			String sql = "insert into azer_test values(?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);

			// step4 execute query
			System.out.println("Inserting new record ID=" + id + " NAME=" + name);
			stmt.executeQuery();
			System.out.println("New record inserted.");

			// step5 close the connection object
			stmt.close();

		} catch (Exception e) {
			out.println(e);
		}
		System.out.println("********************************************");
	}

	private static void updateData(int id1, int id2) {
		try {

			// step3 create the statement object
			String sql = "update azer_test set id=? where id>?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id1); // 999
			stmt.setInt(2, id2); // 5

			// step4 execute query
			System.out.println("Updating records ID>" + id2);
			stmt.executeQuery();
			System.out.println("Records updated to ID=" + id1);

			// step5 close the connection object
			stmt.close();

		} catch (Exception e) {
			out.println(e);
		}
		System.out.println("********************************************");
	}

	private static void deleteData(int id) {
		try {

			// step3 create the statement object
			String sql = "delete from azer_test where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id); // 999

			// step4 execute query
			System.out.println("Deleting records ID=" + id);
			stmt.executeQuery();
			System.out.println("Records deleted ID=" + id);

			// step5 close the connection object
			stmt.close();

		} catch (Exception e) {
			out.println(e);
		}
		System.out.println("********************************************");
	}

	public static void main(String args[]) {
		createConnection();

		// retrieve data
		retrieveResult();

		// insert new record
		insertData(6, "test6");
		insertData(7, "test7");
		insertData(8, "test8");
		insertData(9, "test9");
		insertData(10, "test10");

		// retrieve data
		retrieveResult();

		// update data
		updateData(999, 5); // set id=999 where id>5

		// retrieve data
		retrieveResult();

		// deleting data
		deleteData(999); // delete records where id=999

		// retrieve data
		retrieveResult();
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}