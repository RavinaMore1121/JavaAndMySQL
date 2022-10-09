package hospitalmanagement.view;
import java.sql.SQLException;
import java.util.Scanner;
import hospitalmanagement.drpatient.DrPatient;
import hospitalmanagement.service.DoctorService;
import hospitalmanagement.service.PatientService;
public class MainViewApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
boolean flag=true;
do {
	System.out.println("\nWelcome to HospitalManagement");
	System.out.println("1:Doctor Records");
	System.out.println("2:Patient Records");
	System.out.println("3:view combine Dr and patient data");
	System.out.println("4:exit app");
	System.out.println("enter your choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		boolean dflag=true;
		do {
			System.out.println("\nWelcome to Doctor Records");
			System.out.println("1:Add/inser new Doctor");
			System.out.println("2:view All doctors records");
			System.out.println("3:update doctors records");
			System.out.println("4:delete doctors records");
			System.out.println("5:exit doctor records");
			System.out.println("6:exit app");
			int dchoice=sc.nextInt();
			DoctorService ds=new DoctorService();
			switch(dchoice)
			{
			case 1:
				ds.insertDoctor();
				break;
			case 2:
				System.out.println("================Doctor Records================");
				ds.viewDoctorRec();
				System.out.println("\n==============================================");
				break;
			case 3:
				
				ds.UpdateDoctor();
				break;
			case 4:
				
				ds.deleteDoctor();
				break;
			case 5:
				dflag=false;
				break;
			case 6:
				dflag=false;
				flag=false;
				System.out.println("************Thank You**************");
				break;
			default:
				System.out.println("enter valid choice");
				
			}
		}while(dflag);
		
		break;
	case 2:
		
		boolean pflag=true;
		do {
			System.out.println("\nWelcome to Patients Records");
			System.out.println("1:Add/inser new Patient");
			System.out.println("2:view All patient records");
			System.out.println("3:update Patient record");
			System.out.println("4:delete patient record");
			System.out.println("5:exit patient records");
			System.out.println("6:exit app");
			int dchoice=sc.nextInt();
			PatientService ps=new PatientService();
			switch(dchoice)
			{
			case 1:
				ps.insertPatient();
				break;
			case 2:
				System.out.println("================Patient Records================");
				ps.viewPatientRec();
				System.out.println("\n===============================================");
				break;
			case 3:
				
				ps.UpdatePatient();
				
				break;
			case 4:
				
				ps.deletePatient();
				
				break;
			case 5:
				pflag=false;
				break;
			case 6:
				pflag=false;
				flag=false;
				System.out.println("************Thank You**************");
				break;
			default:
				System.out.println("enter valid choice");
				
			}
		}while(pflag);	
		break;
	case 3:
		DrPatient dp=new DrPatient();
		System.out.println("================Doctor-Patient Records================");
		dp.showDrPatient();
		System.out.println("\n===============================================");
		break;
	case 4:
		System.out.println("************Thank You**************");
		flag=false;
		break;
	default:
		System.out.println("enter valid input");
	}
	
}while(flag);
	}

}
