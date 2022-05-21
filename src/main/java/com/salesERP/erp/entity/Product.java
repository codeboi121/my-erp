package com.salesERP.erp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "product") 
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sl")
	private int id;
	
	@Column(name = "product_name", columnDefinition = "VARCHAR(65)")
	private String productName;
	
	@Column(name = "product_model",columnDefinition = "VARCHAR(65)")
	private String productModel;
	
	@Column(name = "supplier",columnDefinition = "VARCHAR(65)")
	private String supplierName;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "supplier_price")
	private double supplierPrice; 
	
	@Lob //for mapping large objects(here, binary objects)
	@Column(name = "image",columnDefinition = "LONGBLOB")
	private byte[] image;
	
	@Column(name = "product_details",columnDefinition = "VARCHAR(125)")
	private String productDetails;
	
	@Transient
	private String category; //using dropdown menu from POS
	
	@Transient
	private byte[] formImage;
	
	@Transient
	private String unit;
	
	@Transient
	private String barCode;
	
	@Transient
	private String qrCode;
}
