package com.hemebiotech.analytics;

import java.util.Map;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;


public class WriteSymptomDataToFile implements ISymptomWriter{
	
	
	private Map<String, Integer> symptoms;

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		 this.symptoms = symptoms;
		
		if (symptoms !=null) {
			try {
				FileWriter writer = new FileWriter ("result.out");
				
				Set<String> cles = symptoms.keySet();	      
				for(String cle : cles) {					
					int count = symptoms.get(cle);			
					writer.write( cle.getClass().getName() + ": " + count + "\n");
				}
				writer.close();	
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	

	}