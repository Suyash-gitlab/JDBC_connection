package Practice;
import java.util.*;
import java.sql.*;
public class First 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver loaded successfully >> ....");
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/India","postgres","ss24");
		System.out.println("Connection successfull >>>...>");
		
		System.out.println("_______-------STUDENT REGESTRANTION FORM------__________");
		
		System.out.print("Number of student :");
		int n=sc.nextInt();
		String sname,smail,spass;
		
		for(int i=1;i<=n;i++)
		{
			System.out.print("Enter the student name :");
			sname=sc.next();
			System.out.print("Enter the student E-mail :");
			smail=sc.next();
			System.out.print("Enter the student Password :");
			spass=sc.next();
		
			PreparedStatement ps = con.prepareStatement
					("insert into student (sname, smail,spass)values"
							+ "('"+sname+"','"+smail+"','"+spass+"')");
			
			ps.executeUpdate();
		
			System.out.println("Values inserted Successfully >>>");
			System.out.println("----------- THANK YOU -----------");
		}
		sc.close();
		con.close();
	}

}
