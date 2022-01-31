package com.cw.business.rules.json;

import java.util.List;
import java.util.Map;

import com.cw.business.rules.BusinessAction;

public class BusinessActionsCreator {
	
	private String actionableEntity;

	public void createActions(Map<?, ?> JsonMap) {
		// TODO Auto-generated method stub
		
		List<Map<?, ?>> actions = (List<Map<?, ?>>) JsonMap.get("Actions");
		
		
	}
	
	
	public BusinessAction<?> createAction( Map<?, ?> JsonMap ) {
		
		String action =  (String) JsonMap.get("AppliedAction");
		String status =  (String) JsonMap.get("Status");
		String targetStatus =  (String) JsonMap.get("TargetStatus");
		
		List<String> rules = (List<String>) JsonMap.get("BusinessRules");
		
		for (String rule : rules) {
			System.out.println("Rule "+rule);
		}
		
		return null;
	}


}
