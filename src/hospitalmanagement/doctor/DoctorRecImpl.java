package hospitalmanagement.doctor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hospitalmanagement.model.Doctor;

public class DoctorRecImpl implements DoctorRec{
	
	@Override
	public void addNewDoctor(Doctor d) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int drow=0;
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		PreparedStatement statement =con.prepareStatement("insert into doctor values(?,?,?,?)");
		statement.setInt(1, d.getDr_id());
		statement.setString(2, d.getDr_name());
		statement.setString(3, d.getDr_contact());
		statement.setString(4, d.getDr_address());
				drow=statement.executeUpdate();
		
	}
	
	@Override
	public List<Doctor> viewAllDoctors() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<Doctor>doctorList=new ArrayList<Doctor>();
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		//create the connection 
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		
		//create the statement
		PreparedStatement statement =con.prepareStatement("select * from doctor");
		ResultSet rs=statement.executeQuery();
		
		while(rs.next())
		{
			Doctor d=new Doctor();
			d.setDr_id(rs.getInt(1));
			d.setDr_name(rs.getString(2));
			d.setDr_contact(rs.getString(3));
			d.setDr_address(rs.getString(4));
			doctorList.add(d);
		
	}
		return doctorList;
		
	}
	
	public void updateDoctor(Doctor d) throws ClassNotFoundException, SQLException {
		int row=0;
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		PreparedStatement statement =con.prepareStatement("update doctor set dr_name=?,dr_contact=?,dr_address=? where dr_id=?");
		
		statement.setString(1, d.getDr_name());
		statement.setString(2, d.getDr_contact());
		statement.setString(3, d.getDr_address());
		statement.setInt(4, d.getDr_id());
		row=statement.executeUpdate();
	}

	public void deleteDoctor(Doctor d) throws ClassNotFoundException, SQLException {
		
		int row=0;
		Class.forName("com.mysql.cj.jdbc.Driver");//load the driver
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/7462jfs","root","root");
		PreparedStatement statement =con.prepareStatement("delete from doctor where dr_id=?");
		
		
		statement.setInt(1, d.getDr_id());
		row=statement.executeUpdate();
		
	}

	

}