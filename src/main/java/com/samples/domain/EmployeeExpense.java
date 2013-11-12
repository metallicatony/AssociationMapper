package com.samples.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;




/**
 * @author skanniah
 *
 */
@Entity
@Table(name="EMPLOYEE_EXPENSE")
public class EmployeeExpense implements Serializable {

	private static final long serialVersionUID = 6818383372611107291L;

	@Id
	@Column(name="EMP_EXP_ID")
	private Integer empExpId;
	
	@ManyToOne	
	@JoinColumn(name="EMP_ID")
	private Employee employee;
	
	@Column(name="YEAR")
	private Integer year;
	
	@Column(name="MONTH")
	private Integer month;
	
	@Column(name="EXPENSE_CLAIM")
	private Double expenseClaim;
	
	@Column(name="APPROVED_AMT")
	private Double approvedAmt;
	
	@Column(name="PAID_DATE")
	private Date paidDate;

	public Integer getEmpExpId() {
		return empExpId;
	}

	public void setEmpExpId(Integer empExpId) {
		this.empExpId = empExpId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getExpenseClaim() {
		return expenseClaim;
	}

	public void setExpenseClaim(Double expenseClaim) {
		this.expenseClaim = expenseClaim;
	}

	public Double getApprovedAmt() {
		return approvedAmt;
	}

	public void setApprovedAmt(Double approvedAmt) {
		this.approvedAmt = approvedAmt;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

}
