package com.cw.business.rules;

import java.util.Date;

public class Trade implements ActionedEntity {

	
	private String cpty;
	private double amount;
	private Date settlementDate;
	private String status;
	private String actionPerformed;
	
	public Trade() {
		super();
	}
	
	public String getCpty() {
		return cpty;
	}
	public void setCpty(String cpty) {
		this.cpty = cpty;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

	@Override
	public String getActionPerformed() {
		return actionPerformed;
	}

	@Override
	public String toString() {
		return "Trade [status=" + status + ", actionPerformed=" + actionPerformed + ", settlementDate=" + settlementDate
				+ ", cpty=" + cpty + ", amount=" + amount + "]";
	}


	
	
}
