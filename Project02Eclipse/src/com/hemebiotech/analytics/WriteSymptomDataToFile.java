package com.hemebiotech.analytics;

import java.util.Map;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;


public class WriteSymptomDataToFile implements ISymptomWriter{
	
	private String filename;

	public WriteSymptomDataToFile (String filename) {
		this.filename = filename;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		if (symptoms !=null) {
			try {
				FileWriter writer = new FileWriter (filename);
				
				Set<String> cles = symptoms.keySet();	      
				for(String cle : cles) {					
					int count = symptoms.get(cle);			
					writer.write( cle + ": " + count + "\n");
				}
				writer.close();	
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	

	}