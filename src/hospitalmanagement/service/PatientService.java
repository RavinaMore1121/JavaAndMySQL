package hospitalmanagement.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import hospitalmanagement.model.Patient;
import hospitalmanagement.patient.PatientRecImpl;
public class PatientService {
	public void insertPatient() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the patient_name");
		String patient_name=sc.nextLine();
		
		System.out.println("enter the patient_gender");
		String patient_gender=sc.nextLine();

		System.out.println("enter the patient_age");
		int patient_age=sc.nextInt();
        sc.nextLine();
		System.out.println("enter the patient_bloodgroup");
		String patient_bloodgroup=sc.nextLine();

		System.out.println("enter the patient_address");
		String patient_address=sc.nextLine();

		System.out.println("enter the dr_id");
		int dr_id=sc.nextInt();
		
		Patient p=new Patient();
		p.setPatient_name(patient_name);
		p.setPatient_gender(patient_gender);
		p.setPatient_age(patient_age);
		p.setPatient_bloodgroup(patient_bloodgroup);
		p.setPatient_address(patient_address);
		p.setDr_id(dr_id);
		new PatientRecImpl().addNewPatient(p);
	}
	
	public void viewPatientRec() throws ClassNotFoundException, SQLException
	{
		List<Patient>patientlist=new  PatientRecImpl().viewAllPatients();
		for(Patient p:patientlist)
		{
			
			System.out.println(p.getPatient_id()+"\t"+p.getPatient_name()+"\t"+p.getPatient_gender()
			                               +"\t"+p.getPatient_age()+"\t"+p.getPatient_bloodgroup()+"\t"+p.getPatient_address()+"\t"+p.getDr_id());
			
			
		}
	}
	
	public void UpdatePatient() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Patient_id");
		int patientid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Patient_Name");
		String patientname=sc.nextLine();
		System.out.println("Enter the Patient_Age");
		int Age=sc.nextInt();
        sc.nextLine();	
		System.out.println("Enter the Gender");
		String Gender=sc.nextLine();
		System.out.println("Enter the Blood Group");
		String bloodgroup=sc.nextLine();
		System.out.println("Enter The Address");
		String Addres=sc.nextLine();
		
		Patient p=new Patient();
		p.setPatient_id(patientid);
		p.setPatient_name(patientname);
		p.setPatient_age(Age);
		p.setPatient_gender(Gender);
		p.setPatient_bloodgroup(bloodgroup);
		p.setPatient_address(Addres);
		new PatientRecImpl().updatePatient(p);
	}
	
	public void deletePatient() throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Patient_id");
		int patientid=sc.nextInt();
		Patient h=new Patient();
		h.setPatient_id(patientid);
		new PatientRecImpl().deletePatient(h);
	}
}