package com.salesERP.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "unit")
@Data
public class Unit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl")
	private int id;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "status")
	private String status;
}
