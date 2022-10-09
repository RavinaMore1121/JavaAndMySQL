package hospitalmanagement.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import hospitalmanagement.model.Doctor;
import hospitalmanagement.doctor.DoctorRecImpl;
public class DoctorService {
	
	public void insertDoctor() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the dr_id");
	    int dr_id=sc.nextInt();
sc.nextLine();
		System.out.println("enter the dr_name");
		String dr_name=sc.next();
		
		System.out.println("enter the contact");
		String dr_contact=sc.next();
		
		System.out.println("enter the address");
		String dr_address=sc.next();
		Doctor d=new Doctor();
		d.setDr_id(dr_id);
		d.setDr_name(dr_name);
		d.setDr_contact(dr_contact);
		d.setDr_address(dr_address);
		
		
		new DoctorRecImpl().addNewDoctor(d);
	}
	
	public void viewDoctorRec() throws ClassNotFoundException, SQLException
	{
		List<Doctor> doctorlist=new  DoctorRecImpl().viewAllDoctors();
		for(Doctor d:doctorlist)
		{
			
			System.out.println(d.getDr_id()+"\t"+d.getDr_name()+"\t"+d.getDr_contact()+"\t"+d.getDr_address());
		}
	}
	
	public void UpdateDoctor() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Doctor_id");
		int dr_id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Doctor_Name");
		String dr_name=sc.nextLine();
		System.out.println("Enter the Doctor_contact");
		String dr_contact=sc.nextLine();
		System.out.println("Enter the Doctor_Address");
		String dr_address=sc.nextLine();
		
		Doctor d=new Doctor();
		d.setDr_id(dr_id);
		d.setDr_name(dr_name);
		d.setDr_contact(dr_contact);
		d.setDr_address(dr_address);
		new DoctorRecImpl().updateDoctor(d);
		
	}
	public void deleteDoctor() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Doctor_id");
		int dr_id=sc.nextInt();
		Doctor d=new Doctor();
		d.setDr_id(dr_id);
		new DoctorRecImpl().deleteDoctor(d);
	}
}
