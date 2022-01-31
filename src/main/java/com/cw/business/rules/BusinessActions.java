package com.cw.business.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BusinessActions<T extends ActionedEntity> {

	
	private ConcurrentHashMap<BusinessActionKey, List<BusinessAction<T>>> businessActions = new ConcurrentHashMap<BusinessActionKey, List<BusinessAction<T>>>();
	

	public void addAction (BusinessAction<T> action) {
		
		BusinessActionKey key = new BusinessActionKey(action.getStartingStatus(),action.getActionPerformed());
		
		List<BusinessAction<T>> actions = businessActions.computeIfAbsent(key, k ->  new ArrayList<BusinessAction<T>>() );
		actions.add(action);
	}
	
	
	
	public List<BusinessAction<T>> getActions (BusinessActionKey key) {
		return businessActions.computeIfAbsent(key, k ->  new ArrayList<BusinessAction<T>>() );
	}
	
	public T apply (  T oldVersion, T newVersion ) {
		BusinessAction<T> successfulAction;
		
		do {
			successfulAction = findSuccessfulAction(oldVersion, newVersion);
			
			if ( successfulAction!=null ) {
				newVersion.setStatus(successfulAction.getTargetStatus());
			}	
			
		} while(successfulAction!=null);
	
		return newVersion;
	}
	
	
	private BusinessAction<T> findSuccessfulAction	(  T oldVersion, T newVersion ) {

		BusinessActionKey key = new BusinessActionKey(newVersion.getStatus(), newVersion.getActionPerformed());
		
		List<BusinessAction<T>> actions = getActions (key);
		
		BusinessAction<T> successfulAction=null;
		
		for (BusinessAction<T> businessAction : actions) {
			if ( businessAction.attempt(oldVersion, newVersion) ) {
				successfulAction =businessAction;
				break;
			}
		}
		
		
		
		return successfulAction;
	}
	
	
	
}
