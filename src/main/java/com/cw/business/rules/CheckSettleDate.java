package com.cw.business.rules;

public class CheckSettleDate implements BusinessRule<Trade> {

	@Override
	public boolean test(Trade oldVersion, Trade newVersion) {
		
		return true;
	}

	@Override
	public void setSuccessful(Trade oldVersion, Trade newVersion) {
		// TODO Auto-generated method stub
		
	}

}
