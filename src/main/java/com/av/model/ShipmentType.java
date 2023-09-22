package com.av.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipment_type")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name = "sid")
	private Integer shipId;
	@Column(name = "smode")
	private String shipMode;
	@Column(name = "scode")
	private String shipCode;
	@Column(name = "senable")
	private String enableShip;
	@Column(name = "sgrade")
	private String shipGrade;
	@Column(name = "sdesc")
	private String shipDesc;
}
