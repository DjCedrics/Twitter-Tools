import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TwitterDB {
	
	Connection connection = null;
	Statement stmt = null;
	ResultSet rs = null;	
	int linecount;
	public TwitterDB()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		
	 
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://djcedrics.com/cl50-djcedrics","cl50-djcedrics", "kBVh!FXrN");
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs = stmt.executeQuery("SELECT MAX(id) AS id FROM users");
			rs.next();
			linecount = Integer.parseInt(rs.getString("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getLineCount()
	{
		return linecount;
	}
	
	public String getUsername( int id ) throws SQLException
	{
		String sql = "SELECT username FROM users WHERE id = " + id;
		String username = "";
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			username = rs.getString("username");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( "An error occured while trying to get username! ");
		}
		
		return username;	
	}
	
	public String getToken( int id ) 
	{
		String sql = "SELECT oauth_token FROM users WHERE id = " + id;
		String token = "";
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			token = rs.getString("oauth_token");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( "An error occured while trying to get token! ");
		}
		
		return token;	
	}
	
	public String getTokenSecret( int id ) 
	{
		String sql = "SELECT oauth_secret FROM users WHERE id = " + id;
		String token_secret = "";
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			token_secret = rs.getString("oauth_secret");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( "An error occured while trying to get token secret! ");
		}
		
		return token_secret;	
	}
	
	public String getUserID( int id ) 
	{
		String sql = "SELECT oauth_uid FROM users WHERE id = " + id;
		String userID = "-1";
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			userID = rs.getString("oauth_uid");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( "An error occured while trying to get user ID! ");
		}
		
		return userID;	
	}	
	
}
