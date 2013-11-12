package com.samples.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samples.BO.EmployeeBO;
import com.samples.domain.Employee;
import com.samples.domain.EmployeeExpense;
import com.samples.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private static Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    @Autowired
    private EmployeeBO employeeBO;
    
    @Transactional(propagation=Propagation.REQUIRED)
	public Integer createEmployee(String fname, String lname, Integer deptId,
			Long mgrEmpId, Long salary, Date hireDate, Integer jobId) {
		log.info("createEmployee for name=" + fname + " " + lname);
		Integer newEmpId = null;
		try {
			newEmpId = employeeBO.createEmployee(fname, lname, deptId, mgrEmpId, salary, hireDate, jobId);
			return newEmpId;
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return newEmpId;
	}
	
    @Transactional
	public List<Employee> getAllEmployees() {
		log.info("list Employees");
		List<Employee> empList = null;
		try {
			empList = employeeBO.listEmployees();
			log.info("empList size=" + empList.size());
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return empList;
	}
	
    @Transactional(propagation=Propagation.REQUIRED)
	public Employee getEmployee(Integer empId) {
		log.info("get employee");
		Employee emp = null;
		try {
		  	emp = employeeBO.getEmployee(empId);
			if (emp != null) {
				log.info("employee name=" + emp.getFname() + " " + emp.getLname() + " deptId=" + emp.getDepartment().getDeptId());
				for (EmployeeExpense ee: emp.getEmployeeExpenses()) {
					log.info("expense claim=" + ee.getExpenseClaim());
				}
			}
			else {
				log.info("NO employee found with empId=" + empId);
			}
			
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return emp;
	}
	
    @Transactional(propagation=Propagation.REQUIRED)
	public boolean updateEmployeeSalary(Integer empId, Long salary) {
		log.info("update employee");
		boolean result = false;
		try {
			result = employeeBO.updateEmployeeSalary(empId, salary);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return result;
	}
	
    @Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteEmployee(Integer empId) {
		log.info("delete employee");
		boolean result = false;
		try {
			result = employeeBO.deleteEmployee(empId);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		return result;
	}

	public Integer createEmployee() {
		log.info("create employee");
		return null;
	}
}
