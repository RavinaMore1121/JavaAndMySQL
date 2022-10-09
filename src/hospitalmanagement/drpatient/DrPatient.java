package hospitalmanagement.drpatient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DrPatient {
	public void showDrPatient() throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		//create the connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		
		//create the statement
		PreparedStatement statement =con.prepareStatement("select p.patient_id,p.patient_name,p.patient_gender,p.patient_age,d.dr_name,d.dr_contact from patient p inner join doctor d on p.dr_id=d.dr_id");
				
	
	     ResultSet rs=statement.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
		}
		}
}
