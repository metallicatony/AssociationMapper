package com.samples;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.samples.service.EmployeeService;
import com.samples.service.impl.EmployeeServiceImpl;

public class ApplicationMain {
   	
	private static Logger log = LoggerFactory.getLogger(ApplicationMain.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
    	
    	/* Get Employees */
    	employeeService.getEmployee(Integer.valueOf(7369));
    	employeeService.getAllEmployees();
		
    	/* Create new employee */
    	 Integer empId = employeeService.createEmployee("TONY", "RAM",
				new Integer(10), new Long(11), new Long(1000),
				Calendar.getInstance().getTime(), new Integer(5));
		log.info("Employee created with empId=" + empId);
		
		/* Delete employee and check whether expense are also deleted */
		if (employeeService.deleteEmployee(Integer.valueOf(8139))) {
			log.info("delete employee with empId=8139 success");
		} else {
			log.info("delete employee with empId=8139 failure");
		}
	}
}