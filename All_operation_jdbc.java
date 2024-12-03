package Practice;
import java.sql.*;
import java.util.*;
public class Operation 
{

	public static void main(String[] args) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		String sname,smail,spass,change;
		int cid,did;
		
		
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver loaded successfully >> ....");
		
		Connection con = DriverManager.getConnection
				("jdbc:postgresql://localhost:5432/India","postgres","ss24");
		
		System.out.println("Connection successfull >>>...>");
		
		System.out.println("1 Insert");
		System.out.println("2 Update");
		System.out.println("3 Delete");
		System.out.println("4. Exit");
		
		System.out.print("Enter your dicision :");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		
		case 1:
			System.out.println("Enter the name :");
			sname=sc.next();
			System.out.println("Enter the mail :");
			smail=sc.next();
			System.out.println("Enter the pass : ");
			spass=sc.next();
			PreparedStatement ps = con.prepareStatement
			("insert into student (sname, smail,spass)values"
					+ "('"+sname+"','"+smail+"','"+spass+"')");			
			ps.executeUpdate();
			System.out.println("Value inserted successfully ...!!!");
			break;
			
			
		case 2:
			
			System.out.println("Where you want to change :");
			cid=sc.nextInt();
			System.out.println("Enter the name to change :");
			change=sc.next();
			PreparedStatement os = con.prepareStatement
			("update student set sname='"+change+"' where sid='"+cid+"'");
			os.executeUpdate();
			System.out.println("Value Update successfully ...!!!");
			break;
			
			
			
		case 3:
			System.out.println("Enter the id you want to delete :");
			did=sc.nextInt();
			PreparedStatement ds = con.prepareStatement
			("delete from student where sid ='"+did+"'");
			ds.executeUpdate();
			System.out.println("Value Delete successfully ...!!!");

			break;
			
		default:
			System.out.println("thank you ");
			break;	
		
		}	
		
	}

}
