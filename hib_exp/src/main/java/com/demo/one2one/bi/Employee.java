package com.demo.one2one.bi;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_table_one2one_bi")
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eid;
	private String name;
	
	@OneToOne(mappedBy="employee", cascade=CascadeType.PERSIST)
	private Parking parking;
	
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", parking="
				+ parking + "]";
	}
	
	
}
