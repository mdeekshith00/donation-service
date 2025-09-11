package com.donation.entity;

import java.util.List;

public class TransferShipment {
	private Integer shipmentId;
	private String fromLocation; // temperatureLog` (link to logs)
	private String toLocation;
	private String tempatureLog;
	private List<Integer> components;// (list of componentIds)
	private String shippedAt;
	private String receivedAt;
	private String carrierInfo;
	

}
