package com.cw.business.rules.json;

import java.util.List;

public class BusinessActionsJson {

	
	private String actionableEntity;
	
	List<BusinessActionJson> actions;

	public String getActionableEntity() {
		return actionableEntity;
	}

	public void setActionableEntity(String actionableEntity) {
		this.actionableEntity = actionableEntity;
	}

	public List<BusinessActionJson> getActions() {
		return actions;
	}

	public void setActions(List<BusinessActionJson> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "BusinessActionsJson [actionableEntity=" + actionableEntity + ", actions=" + actions + "]";
	}
	
	
	
}
