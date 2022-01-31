package com.cw.business.rules.json;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import com.google.gson.Gson;

public class JSONLoader {

	public void write(BusinessActionsJson businessActionsJson) {
		
		try ( Writer writer = Files.newBufferedWriter(Paths.get("book.json"))) {

		    // create Gson instance
		    Gson gson = new Gson();

		    // convert book object to JSON file
		    gson.toJson(businessActionsJson, writer);

		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public BusinessActionsJson read() {
		
		BusinessActionsJson businessActionsJson = null;
		
		try (    Reader reader = Files.newBufferedReader(Paths.get("user.json")); ) {
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader

		    businessActionsJson = gson.fromJson(reader,BusinessActionsJson.class);
		    
		    
		    System.out.println(businessActionsJson);
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		
	    return businessActionsJson;
		
	}
	
	public static void main(String[] args) {
		JSONLoader loader = new JSONLoader();
		
		BusinessActionsJson businessActionsJson =loader.read();
		
		loader.write(businessActionsJson);
	}
}
