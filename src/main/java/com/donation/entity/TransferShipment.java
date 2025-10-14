package com.donation.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transfer_shipment")
public class TransferShipment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
	private Integer shipmentId;
	
    @Column(nullable = true)
	private String fromLocation; // temperatureLog` (link to logs)
    
    @Column(nullable = true)
	private String toLocation;
	
	private String tempatureLog;
	
	private List<Integer> components;// (list of componentIds)
	
	private String shippedAt;
	
	private String receivedAt;
	
	private String carrierInfo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_id", nullable = false)
	@JsonBackReference
	private Lab lab;

	@OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<BloodComponent> bloodComponents;

	

}
