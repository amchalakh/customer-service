package com.edusol.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@Column
	private int customerId;
	@Column
	private String customerName;
	@Column
	private String cutsomerCity;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCutsomerCity() {
		return cutsomerCity;
	}

	public void setCutsomerCity(String cutsomerCity) {
		this.cutsomerCity = cutsomerCity;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", cutsomerCity="
				+ cutsomerCity + "]";
	}

	
	
	

}
