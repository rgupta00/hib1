package com.demo.one2one.uni;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name="parking_table_one2one_uni")
public class Parking {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String name;
	
	@JoinColumn(name="eid_fk")
	@OneToOne(fetch=FetchType.EAGER)
	private Employee employee;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Parking [pid=" + pid + ", name=" + name +  "]";
	}
	
	
	
	
}
