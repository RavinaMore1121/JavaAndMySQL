package hospitalmanagement.model;
public class Doctor {
	private int dr_id;
	private String dr_name;
	private String dr_contact;
	private String dr_address;
	
	public String getDr_contact() {
		return dr_contact;
	}
	public void setDr_contact(String dr_contact) {
		this.dr_contact = dr_contact;
	}
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public String getDr_name() {
		return dr_name;
	}
	public void setDr_name(String dr_name) {
		this.dr_name = dr_name;
	}
	public String getDr_address() {
		return dr_address;
	}
	public void setDr_address(String dr_address) {
		this.dr_address = dr_address;
	}

}
