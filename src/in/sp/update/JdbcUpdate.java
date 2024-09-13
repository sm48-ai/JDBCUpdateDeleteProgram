package in.sp.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Scanner;

public class JdbcUpdate {

	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name to Update:");
		String myname=sc.nextLine();
		
		System.out.println("Enter your City:");
		String mycity=sc.nextLine();
		
		System.out.println("Enter your emailID:");
		String myemail=sc.nextLine();
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/jdbac_Db";
		Connection con=DriverManager.getConnection(url, "root", "8576");
		
		String updateQuery="update register set name=?, city=? where email=?";

		PreparedStatement ps=con.prepareStatement(updateQuery);
		
		ps.setString(1, myname);
		ps.setString(2, mycity);
		ps.setString(3, myemail);
		

		
		int c=ps.executeUpdate();
		if (c>0) {
			System.out.println("<h1 style='color:green'>Your Updation is Successfull</h1>");
		}else {
			System.out.println("Updation failed");
		}
	
		con.close();
	
	}

}
