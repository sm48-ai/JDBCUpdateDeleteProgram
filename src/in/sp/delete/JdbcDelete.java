package in.sp.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcDelete {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbac_Db", "root", "8576");

		System.out.println("Creating Conection...............");
		String deleteSqlQuery="delete from register where email=?";
		PreparedStatement  ps=con.prepareStatement(deleteSqlQuery);
		System.out.println("Enter your Email ID:");
		String email1=sc.nextLine();
		ps.setString(1, email1);
		int c=ps.executeUpdate();
		if (c>0) {
			System.out.println("Deletion Successfull");
		}else {
			System.out.println("Deletion Failure");
		}
	}

}
