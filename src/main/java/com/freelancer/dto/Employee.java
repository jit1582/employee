/**
 * 
 */
package com.freelancer.dto;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Jitendra. P. Patil
 *
 */
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Employee() {
		initializeEmployee("Aryan", "Malhotra", 0);
	}
	public Employee(String firstName) {
		initializeEmployee(firstName, "Malhotra", 0);
	}
	
	public Employee(String firstName, String lastName) {
		initializeEmployee(firstName, lastName, 0);
	}
	
	public Employee(String firstName, String lastName, double salary) {
		initializeEmployee(firstName, lastName, salary);
	}

	private void initializeEmployee(String firstName, String lastName, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary > -1 ? roundThreeDecimals(salary) : 0;
		this.employeeId = initializeEmployeeId();
		code++;
		
	}
	private String initializeEmployeeId() {
		return this.firstName.substring(0, 1) + this.lastName.substring(0, 1) + code;
	}
	private static int code = 1001;
	
	private String employeeId;
	private String firstName = "Aryan";
	private String lastName = "Malhotra";
	private double salary;

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary > -1 ? roundThreeDecimals(salary) : this.salary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	
	private double roundThreeDecimals(double d) {
	    DecimalFormat twoDForm = new DecimalFormat("#.###");
	    return Double.valueOf(twoDForm.format(d));
	}

}
