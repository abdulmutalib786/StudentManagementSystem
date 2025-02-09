package SMS.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNo;
       
	@Column
	private String name;

	@Column
	private String branch;

	// constructors
	public Students() {
	}

	public Students(String name, String branch) {
		this.name = name;
		this.branch = branch;
	}

	public Students(int rollNo, String name, String branch) {
		this.rollNo = rollNo;
		this.name = name;
		this.branch = branch;
	}
  
	// getters and setters
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
