package com.donation.vo;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class CreateLabVO {
	
	@Size(min =2 , max = 15)
	@NotNull
	private String labName;

    private String location;

    private String contactPerson;

    @Email(message = "Invalid email format")
	@NotNull
    private String contactEmail;
    
	@NotNull(message = "Phone number cannot be null")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits")
    private String contactPhone;

    private String registrationNumber; // optional govt registration ID

    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;


}
