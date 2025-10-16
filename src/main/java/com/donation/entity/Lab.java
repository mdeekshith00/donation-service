package com.donation.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "lab")
public class Lab  implements Serializable {

		    private static final long serialVersionUID = 1L;

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "lab_id")
		    private Integer labId;

		    @Column(nullable = false)
		    private String labName;

		    @Column(nullable = false)
		    private String location;

		    @Column(nullable = false)
		    private String contactPerson;

		    @Column(nullable = false)
		    private String contactEmail;

		    @Column(nullable = false)
		    private String contactPhone;

		    @Column(nullable = true)
		    private String registrationNumber; // optional govt registration ID

		    @Column(nullable = false)
		    private LocalDateTime createdAt;

		    @Column(nullable = false)
		    private LocalDateTime updatedAt;
		    
		    @OneToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "donation_id")
		    @JsonBackReference
		    private DonationEvent donationEvent;
		    
		 // 1 lab can process multiple blood components
		    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		    @JsonManagedReference
		    private List<BloodComponent> bloodComponents = new ArrayList<>();

		    // 1 lab can process multiple blood tests
		    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		    @JsonManagedReference
		    private List<BloodTest> bloodTest = new ArrayList<>();
		    
		    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		    @JsonManagedReference
		    private List<BloodSample> bloodSamples;
		    
		    @OneToMany(mappedBy = "lab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		    @JsonManagedReference
		    private List<TransferShipment> shipments;


}
