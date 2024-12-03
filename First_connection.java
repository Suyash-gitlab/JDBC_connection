package Practice;
import java.sql.*;
import java.util.*;
public class Emp 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String ename,epass;
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver loaded successfullyy :");
		Connection con = DriverManager.getConnection
				("jdbc:postgresql://localhost:5432/India","postgres","ss24");
		System.out.println("Connection Established :");
		
		System.out.println("Enter the name :");
		ename=sc.next();
		System.out.println("Enter the password :");
		epass=sc.next();
		PreparedStatement ps =con.prepareStatement("insert into emp (ename,epass)values('"+ename+"','"+epass+"')");
		ps.executeUpdate();
	}

}
