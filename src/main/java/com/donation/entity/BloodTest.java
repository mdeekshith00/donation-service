package com.donation.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.donation.enums.BloodGroupType;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "blood_test_result")
public class BloodTest  implements Serializable {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "blood_test_result_id")
	    private Integer bloodTestResultId;
	    
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "lab_id")
		@JsonBackReference
		private Lab lab;
	    
	    @Column(name = "bloodGroupConfirmed" ,nullable = false)
	    private BloodGroupType bloodGroupConfirmed;

	    @Column(nullable = false)
	    private Boolean HIVTest;

	    @Column(nullable = false)
	    private String HepatitisBTest;

	    @Column(nullable = false)
	    private String HepatitisCTest;
 
	    @Column(nullable = false)
	    private String SyphilisTest;

	    @Column(nullable = false)
	    private String MalariaTest;

	    @Column(length = 200)
	    private String otherTests; // free-text for additional tests

	    @OneToOne(mappedBy = "bloodTest", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	    @JsonBackReference
	    private TestResult resultStatus; 

	    @Column(length = 50, nullable = false)
	    private String testedBy; // labtech id or name

	    @Column(nullable = false)
	    private LocalDateTime testDateTime;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "sample_id")
	    @JsonBackReference
	    private BloodSample bloodSample;
	


}
