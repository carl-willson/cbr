package com.cw.business.rules;

import java.util.Objects;

public class BusinessActionKey {

	private final String status;
	private final String action;
	private int hashCode;

	
	
	public BusinessActionKey(String status, String action) {
		super();
		this.status = status;
		this.action = action;
		this.hashCode = Objects.hash(status, action);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BusinessActionKey that = (BusinessActionKey) o;
		return status == that.status && action == that.action;
	}

	@Override
	public int hashCode() {
		return this.hashCode;
	}
}