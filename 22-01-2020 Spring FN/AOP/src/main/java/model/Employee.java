package model;

public class Employee {
	private Integer empId;
	private String empName;
	private String pos;
	
	public Employee(){}
	
	public Employee(Integer empId, String empName, String pos) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.pos = pos;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	
}
