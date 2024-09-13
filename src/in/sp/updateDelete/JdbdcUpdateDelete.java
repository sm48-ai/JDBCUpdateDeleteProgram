package in.sp.updateDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbdcUpdateDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter  your name:");
		String myname = sc.nextLine();
		
		System.out.println("Enter your Email ID:");
		String myemail = sc.nextLine();
		
		System.out.println("Enter your Password:");
		String mypass = sc.nextLine();
		
		System.out.println("Enter your Gender:");
		String gender = sc.nextLine();
		
		System.out.println("Enter Your City:");
		String mycity = sc.nextLine();

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbac_Db", "root", "8576");

		String insertSqlQuery = "insert into register values(?,?,?,?,?)";

		PreparedStatement ps = con.prepareStatement(insertSqlQuery);
		ps.setString(1, myname);
		ps.setString(2, myemail);
		ps.setString(3, mypass);
		ps.setString(4, gender);
		ps.setString(5, mycity);

		int count = ps.executeUpdate();
		if (count > 0) {
			System.out.println("Data insertion Successfull");
		} else {
			System.out.println("Data insertion Failure");
		}

	}

}
