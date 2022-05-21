package com.salesERP.erp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name = "sales")
public class Sale {
	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "SL")
	private int id;
	
	@Column(name = "invoice_no")
	private int invoiceNo;
	
	@Column(name = "sale_by")
	private String saleBy;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "date")
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;
	
	@Column(name = "total_amount")
	private String totalAmount;

}
