package com.cw.business.rules.json;

import java.util.ArrayList;
import java.util.List;

public class BusinessActionJson {

	
	// starting point
	private String startingStatus;
	
	// Action
	private String actionPerformed;
	
	// Resulting Status
	private String endingStatus;
	

	// BusinessRules
	private List<String> rules = new ArrayList<>();


	@Override
	public String toString() {
		return "BusinessActionJson [startingStatus=" + startingStatus + ", actionPerformed=" + actionPerformed
				+ ", endingStatus=" + endingStatus + ", rules=" + rules + "]";
	}
	
	
	
}
