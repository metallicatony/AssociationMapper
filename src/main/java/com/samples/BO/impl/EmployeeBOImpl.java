package com.samples.BO.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.samples.BO.EmployeeBO;
import com.samples.DAO.EmployeeDAO;
import com.samples.domain.Department;
import com.samples.domain.Employee;

@Component("employeeBO")
public class EmployeeBOImpl implements EmployeeBO {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public Integer createEmployee(String fname, String lname, Integer deptId, 
			Long mgrEmpId, Long salary, Date hireDate, Integer jobId) {
			
		 /** 
		 * With department id, get the department object 
		 * if it is null, create a new dept object
		 * if not null, set the dept object in employee and then call save 
		 **/
		
		Department dept = employeeDAO.getDepartment(deptId);
		if (dept == null) {
			dept = new Department();
			dept.setDeptId(dept.getDeptId());
			dept.setLocationId(Integer.valueOf(999));
			dept.setName("NEW DEPT");
		}
		
		// Create Employee here
		// Do other business validations here for all the values
		Employee employee = new Employee();
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setMgrEmpId(mgrEmpId);
		employee.setSalary(salary);
		employee.setHireDate(hireDate);
		employee.setJobId(jobId);
		employee.setActive(true);

		// Set Bidirectional association - employee in dept and dept in employee objects
		employee.setDepartment(dept);
		dept.getEmployees().add(employee);
		return employeeDAO.add(employee);
	} 

	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	public Employee getEmployee(Integer empId) {
		return employeeDAO.getEmployee(empId);
	}
	
	public boolean updateEmployeeSalary(Integer empId, Long salary) throws Exception {
		return employeeDAO.updateEmployeeSalary(empId, salary);
	}
	
	public boolean deleteEmployee(Integer empId) throws Exception {
		return employeeDAO.deleteEmployee(empId);
	}

}
