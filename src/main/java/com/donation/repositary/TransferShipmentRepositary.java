package com.donation.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.entity.TransferShipment;

public interface TransferShipmentRepositary extends JpaRepository<TransferShipment, Integer>{

}
