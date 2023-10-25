package OneToMany_dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gst;

	@OneToMany // (fetch = FetchType.EAGER)
	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;

	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", gst=" + gst + ", employee=" + employee + "]";
	}
}
