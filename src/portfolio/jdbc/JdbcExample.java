package portfolio.jdbc;

import java.sql.*;
import static java.lang.System.out;

public class JdbcExample {

	public static final String DBURL = "jdbc:oracle:thin:@localhost:1521/CLOUDDB.testdb.az";
	// public static final String DBURL = "jdbc:mysql://localhost:3306/DB_NAME";
	public static final String DBUSER = "dba_maintenance";
	public static final String DBPASS = "Dbaw34ef24nce321";

	public static void main(String args[]) {
		try {
//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.mysql.jdbc.driver");

//step2 create  the connection object  
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

//step3 create the statement object  
			Statement stmt = con.createStatement();

//step4 execute query  
			String sql = "select id, db_name from tbl_db_names";
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				if ((i % 7 == 0)) // Group records by 7
					System.out.println("------------------------------");
				i++;
				out.println(rs.getInt(1) + "\t" + rs.getString(2)); // firt column + <TAB> + second column

			}
			System.out.println("------------------------------");

//step5 close the connection object  
			con.close();

		} catch (Exception e) {
			out.println(e);
		}

	}
}