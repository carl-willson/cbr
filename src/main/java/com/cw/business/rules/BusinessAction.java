package com.cw.business.rules;

import java.util.ArrayList;
import java.util.List;

public class BusinessAction<T> {

	
	// starting point
	private String startingStatus;
	
	// Action
	private String actionPerformed;
	
	// Resulting Status
	private String targetStatus;
	

	// BusinessRules
	private List<BusinessRule<T>> rules = new ArrayList<BusinessRule<T>>();

	
	public BusinessAction(String startingStatus, String actionPerformed, String targetStatus) {
		super();
		this.startingStatus = startingStatus;
		this.actionPerformed = actionPerformed;
		this.targetStatus = targetStatus;
	}


	public String getStartingStatus() {
		return startingStatus; 
	}


	public void setStartingStatus(String startingStatus) {
		this.startingStatus = startingStatus;
	}


	public String getActionPerformed() {
		return actionPerformed;
	}


	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}


	public String getTargetStatus() {
		return targetStatus;
	}


	public void setTargetStatus(String targetStatus) {
		this.targetStatus = targetStatus;
	}


	public void addRule (BusinessRule<T> newRule ) {
		rules.add(newRule);
	}
	
	
	public List<BusinessRule<T>> getRules() {
		return rules;
	}


	public void setRules(List<BusinessRule<T>> rules) {
		this.rules = rules;
	}
	
	
	public boolean attempt(T oldEntity, T entity ) {
		
		boolean pass = true;
		
		for (BusinessRule<T> businessRule : rules) {
			pass = businessRule.test(oldEntity, entity);
			if ( !pass) {
				break;
			}
		}
		
		if ( pass ) {
			System.out.println("Action passed");

			//entity.
			
			for (BusinessRule<T> businessRule : rules) {
				businessRule.setSuccessful(oldEntity, entity);
			}
			
			
			
		} else {
			System.out.println("Action Failed");
		}
		
		return pass;
	}
	
	
}
