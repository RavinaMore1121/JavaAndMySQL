package hospitalmanagement.patient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hospitalmanagement.model.Patient;
public class PatientRecImpl implements PatientRec{

	@Override
	public void addNewPatient(Patient p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		int prow=0;
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		PreparedStatement statement =con.prepareStatement("insert into patient values('0',?,?,?,?,?,?)");
		statement.setString(1, p.getPatient_name());
		statement.setString(2, p.getPatient_gender());
		statement.setInt(3,p.getPatient_age());
		statement.setString(4, p.getPatient_bloodgroup());
		statement.setString(5, p.getPatient_address());
		statement.setInt(6, p.getDr_id());
		prow=statement.executeUpdate();
	}
  
	@Override
	public List<Patient> viewAllPatients() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<Patient>patientList=new ArrayList<Patient>();
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		//create the connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		
		//create the statement
		PreparedStatement statement =con.prepareStatement("select * from patient");
		ResultSet rs=statement.executeQuery();
		
		while(rs.next())
		{
			Patient p=new Patient();
			p.setPatient_id(rs.getInt(1));
			p.setPatient_name(rs.getString(2));
			p.setPatient_gender(rs.getString(3));
			p.setPatient_age(rs.getInt(4));
			p.setPatient_bloodgroup(rs.getString(5));
			p.setPatient_address(rs.getString(6));
			p.setDr_id(rs.getInt(7));
			patientList.add(p);
		
	}
		return patientList;
	}
	
	@Override
	public void updatePatient(Patient p) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		PreparedStatement statement =con.prepareStatement("update patient set patient_name=?,patient_age=?,patient_gender=?,patient_bloddgroup=?,patient_address=? where patient_id=?");
		
	
		statement.setString(1, p.getPatient_name());
		statement.setInt(2, p.getPatient_age());
		statement.setString(3,p.getPatient_gender());
		statement.setString(4,p.getPatient_bloodgroup());
		statement.setString(5, p.getPatient_address());
		statement.setInt(6, p.getPatient_id());
		row=statement.executeUpdate();
		
	}
	@Override
	public void deletePatient(Patient p) throws ClassNotFoundException, SQLException {
		
		int row=0;
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		PreparedStatement statement =con.prepareStatement("delete from patient where patient_id=?");
		
		
		statement.setInt(1, p.getPatient_id());
		row=statement.executeUpdate();
	}

}