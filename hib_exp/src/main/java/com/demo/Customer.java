package com.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="c_table_2")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="c_name", length=100, nullable=false)
	private String name;
	@Column(name="c_address", length=100, nullable=false)
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column(name="c_dob", length=100, nullable=false)
	private Date dob;
	
	@Transient
	private String tempPass;
	
	public Customer(){}

	public Customer(String name, String address, Date dob, String tempPass) {
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.tempPass = tempPass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getTempPass() {
		return tempPass;
	}
	public void setTempPass(String tempPass) {
		this.tempPass = tempPass;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ ", dob=" + dob + ", tempPass=" + tempPass + "]";
	}
	
	
}
