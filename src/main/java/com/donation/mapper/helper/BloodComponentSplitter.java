package com.donation.mapper.helper;

import java.util.HashMap;
import java.util.Map;

import com.donation.enums.ComponentType;

public class BloodComponentSplitter {


	    public static Map<ComponentType, Double> splitBlood(double totalVolume, boolean fullSeparation) {
	        double sampleVolume = 10.0;
	        double remaining = totalVolume - sampleVolume;
	        Map<ComponentType, Double> result = new HashMap<>();

	        if (remaining <= 0) {
	            throw new IllegalArgumentException("Invalid blood volume, less than required sample amount");
	        }

	        if (fullSeparation) {
	            // Standard split (can be moved to DB/config later)
	            result.put(ComponentType.RBC, remaining * 0.50);
	            result.put(ComponentType.PLASMA, remaining * 0.40);
	            result.put(ComponentType.PLATELETS, remaining * 0.08);
	            result.put(ComponentType.CRYO, remaining * 0.02);
	        } else {
	            // Partial split (only some components)
	            if (remaining < 300) {
	                // Not enough for all – focus on RBC and Plasma only
	                result.put(ComponentType.RBC, remaining * 0.60);
	                result.put(ComponentType.PLASMA, remaining * 0.40);
	            } else {
	                // Slightly larger – include Platelets too
	                result.put(ComponentType.RBC, remaining * 0.55);
	                result.put(ComponentType.PLASMA, remaining * 0.35);
	                result.put(ComponentType.PLATELETS, remaining * 0.10);
	            }
	        }

	        return result;
	    
	}


}
