package com.samples.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samples.BO.EmployeeBO;
import com.samples.BO.impl.EmployeeBOImpl;
import com.samples.domain.Employee;
import com.samples.domain.EmployeeExpense;


public interface EmployeeService {
	public Employee getEmployee(Integer empId);
	public List<Employee> getAllEmployees();
	public Integer createEmployee(String fname, String lname, Integer deptId,
			Long mgrEmpId, Long salary, Date hireDate, Integer jobId);
	public boolean deleteEmployee(Integer empId);
}