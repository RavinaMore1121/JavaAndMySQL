package hospitalmanagement.patient;
import java.sql.SQLException;
import java.util.List;
import hospitalmanagement.model.Patient;
public interface PatientRec {
public void addNewPatient(Patient p) throws ClassNotFoundException, SQLException;
public List<Patient> viewAllPatients() throws ClassNotFoundException, SQLException;
public void updatePatient(Patient p) throws ClassNotFoundException, SQLException;
public void deletePatient(Patient p) throws ClassNotFoundException, SQLException;
}
