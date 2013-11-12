package com.samples.DAO;
import java.util.List;

import com.samples.domain.Department;
import com.samples.domain.Employee;

public interface EmployeeDAO {
	public Integer add(Employee empl);
	public List<Employee> listEmployees();
	public Employee getEmployee(Integer empId);
	public boolean updateEmployeeSalary(Integer empId, Long salary) throws Exception;
	public boolean deleteEmployee(Integer empId) throws Exception;
	public Department getDepartment(Integer deptId);
}