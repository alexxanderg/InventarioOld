/*package utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySQLConexion {
	public MySQLConexion(){}
	
	private static String URL="jdbc:mysql://localhost:3306/db_inventario?useSSL=false";
	private static String USER="root";
	private static String PASS="Aa123";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public static Connection getConection(){
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return conn;
	}
}
*/

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQLConexion {
	public MySQLConexion(){}
	
	private static String URL="jdbc:mysql://192.168.0.101:3306/db_inventario";
	private static String USER="prueba";
	private static String PASS="a  a123";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConection(){
		Connection con = null;
		try {
			con=DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
