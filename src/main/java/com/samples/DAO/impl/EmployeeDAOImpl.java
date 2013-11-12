package com.samples.DAO.impl;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.samples.DAO.EmployeeDAO;
import com.samples.domain.Department;
import com.samples.domain.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Logger log = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	private final Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Integer add(Employee empl) {
		Integer empId = (Integer) getSession().save(empl);
		return empId;
	}

	public List<Employee> listEmployees() {
		List<Employee> empList = null;
		Session session = getSession();
		empList = (List<Employee>) session.createQuery("from Employee").list();
		return empList;
	}
	
	public Employee getEmployee(Integer empId) {
		Session session = getSession();
		Employee emp = null;
		emp = (Employee) session.get(Employee.class, empId);
		if (emp != null) {
			log.info("employee Expense size=" + emp.getEmployeeExpenses().size());
		}
		else {
			log.info("employee id=" + empId + " does not exist");
		}
		return emp;
	}
	
	public boolean updateEmployeeSalary(Integer empId, Long salary) {
		Session session = getSession();
		boolean result = false;
		Employee emp = (Employee) session.get(Employee.class, empId);
		if (emp != null) {
				emp.setSalary(salary);
				session.saveOrUpdate(emp);
				result = true;
				log.info("updated salary of emp id=" + empId);
		}
		return result;
	}
	
	public boolean deleteEmployee(Integer empId) throws Exception {
		Session session = getSession();
		boolean result = false;
		Employee emp = (Employee) session.get(Employee.class, empId);
		if (emp != null) {
			session.delete(emp);
			result = true;
			log.info("deleted emp id=" + emp.getEmpId());
		}
		return result;
	}

	public Department getDepartment(Integer deptId) {
		Session session = getSession();
		Department dept = null;
		dept = (Department) session.get(Department.class, deptId);
		if (dept != null) {
			log.info("department id=" + dept.getDeptId());
		}
		else {
			log.info("department id=" + deptId + " does not exist");
		}
		return dept;
	}
}
