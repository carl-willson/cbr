package com.cw.business.rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;

public class TradeProcessor {

	
	private BusinessRules businessRules;
	
	
	
	public TradeProcessor(BusinessRules businessRules) {
		super();
		this.businessRules = businessRules;
	}


	public Trade process (Trade incomingTrade) {
		
		
		return incomingTrade;
	}
	
	
	public void goForIt () {
		
	}
	
	
    public static void main(String[] args) {  
    	
 //   	TradeProcessor tradeProcessor = new TradeProcessor( new BusinessRules());
    	
//    	tradeProcessor.goForIt();
    	
    	
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
