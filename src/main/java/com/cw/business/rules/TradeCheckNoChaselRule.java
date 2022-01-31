package com.cw.business.rules;

public class TradeCheckNoChaselRule implements BusinessRule<Trade> {

	@Override
	public boolean test(Trade oldVersion, Trade newVersion) {
		String cpty = newVersion.getCpty();
		
		return !cpty.equals("CHASEL");
	}

	@Override
	public void setSuccessful(Trade oldVersion, Trade newVersion) {
		
	}

}
