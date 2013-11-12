package com.samples.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;




/**
 * @author skanniah
 *
 */
@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable {

	private static final long serialVersionUID = 619193918993165386L;

	@Column(name="DEPT_ID")
	@Id
	private Integer deptId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location_id")
	private Integer locationId;
	
	@OneToMany(mappedBy="department")
	@Cascade(CascadeType.ALL)
	private Set<Employee> employees;
	
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
