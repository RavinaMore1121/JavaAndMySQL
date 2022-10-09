package hospitalmanagement.doctor;
import java.sql.SQLException;
import java.util.List;
import hospitalmanagement.model.Doctor;
public interface DoctorRec {
	public void addNewDoctor(Doctor d) throws ClassNotFoundException, SQLException;
    public List<Doctor> viewAllDoctors() throws ClassNotFoundException, SQLException;
    public void updateDoctor(Doctor d) throws ClassNotFoundException, SQLException;
    public void deleteDoctor(Doctor d) throws ClassNotFoundException, SQLException;
}