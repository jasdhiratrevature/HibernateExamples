package com.revature.mappings.mtm;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "employees_projects", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
			@JoinColumn(name = "project_id") })
	Set<Project> projects = new HashSet<Project>();

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(String firstName, String lastName, Set<Project> projects) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.projects = projects;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
