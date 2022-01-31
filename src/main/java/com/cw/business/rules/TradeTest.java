package com.cw.business.rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TradeTest {

	
	private static Logger LOGGER = LoggerFactory.getLogger(TradeTest.class.getName());
	
	private BusinessActions<Trade> businessActionSet;
	
	
	
	public TradeTest(BusinessActions<Trade> businessRules) {
		super();
		this.businessActionSet = businessRules;
	}
	
	
	public void goForIt () {
		
		setUpRules();
		
		// Create new Trade
		Trade t = new Trade();
		
		try {
			t.setCpty("CHASE");
			t.setSettlementDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2021-12-12 00:00:00"));
			t.setStatus("CREATED");
			t.setAmount(100000);
			t.setActionPerformed("NEW");
			
			LOGGER.info("Processing Trade [{}]",t);
			
			t = process(t);

			LOGGER.info("Trade is now [{}]",t);

		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void setUpRules() {
		BusinessAction<Trade> verifiedAction = new BusinessAction<Trade>("CREATED", "NEW", "VERIFIED");
		verifiedAction.addRule(new CheckSettleDate());
		verifiedAction.addRule(new TradeCheckNoChaselRule());
		
		businessActionSet.addAction(verifiedAction);
		
	}
	
	public Trade process (Trade incomingTrade) {
		
		
		businessActionSet.apply(null, incomingTrade);
		// 1. Get applicable Business Rules
		
		
		// Apply Business Rules
		
		
		return incomingTrade;
	}
	
	
    public static void main(String[] args) {  
    	
    	TradeTest tradeTest = new TradeTest( new BusinessActions<Trade>());
    	
    	tradeTest.goForIt();
    	
    	
//        ExecutorService executorService = Executors.newFixedThreadPool(10);  
//        executorService.execute(new Runnable() {  
//              
//            @Override  
//            public void run() {  
//                System.out.println("ExecutorService");  
//                  
//            }  
//        });  
//        executorService.shutdown();  
    }  	
	
}
