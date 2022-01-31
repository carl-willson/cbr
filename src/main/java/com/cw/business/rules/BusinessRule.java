package com.cw.business.rules;

public interface BusinessRule<T> {

	
	public boolean test (T oldVersion, T newVersion);
	
	public void setSuccessful(T oldVersion, T newVersion);
	
}
