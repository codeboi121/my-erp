package com.salesERP.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	// define fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SL")
	private int id;
	
	@Column(name = "Customer_Name")
	private String customerName;
	
	@Column(name = "Address1")
	private String address1;
	
	@Column(name = "Mobile_No")
	private String mobile;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "Zip_Code")
	private int zipCode;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Balance")
	private double balance;

}
