package com.cw.business.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BusinessRules {

	private ConcurrentHashMap<String, List<BusinessRule<Trade>>> businessRules = new ConcurrentHashMap<String, List<BusinessRule<Trade>>>();
	
	
	public void addRule(String status, BusinessRule<Trade> rule) {

		List<BusinessRule<Trade>> applicableRules = businessRules.computeIfAbsent(status, k ->  new ArrayList<BusinessRule<Trade>>() );
		applicableRules.add(rule);

	}
	
	
	public Trade apply(Trade trade) {
		
		String status = trade.getStatus();
		
		List<BusinessRule<Trade>> applicableRules = businessRules.computeIfAbsent(status, k ->  new ArrayList<BusinessRule<Trade>>() );
		
		boolean testResult = false;
		
		for (BusinessRule businessRule : applicableRules) {
			testResult = businessRule.test(null, trade);
			if ( !testResult) {
				break;
			}
		}
		
		return trade;
	}
}
