package com.demo.cpk;

import java.io.Serializable;

import javax.persistence.Embeddable;

//it must imp serilization
@Embeddable
public class CustomerPk implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String regNumber;

	//must have default ctr
	public CustomerPk() {}

	
	public CustomerPk(int id, String regNumber) {
		this.id = id;
		this.regNumber = regNumber;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}


	@Override
	public String toString() {
		return "CustomerPk [id=" + id + ", regNumber=" + regNumber + "]";
	}
	
	
	
}
