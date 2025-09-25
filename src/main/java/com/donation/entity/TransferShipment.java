package com.donation.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class TransferShipment {
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
	

}
