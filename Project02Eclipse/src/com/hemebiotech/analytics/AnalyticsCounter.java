package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter{
	
	 private ISymptomReader reader;
	 private ISymptomWriter writer;
	
	 public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
	        this.reader = reader;
	        this.writer = writer;
	    }
	
	 public List<String> getSymptoms() {
		    return reader.GetSymptoms();
		}

	 public Map<String, Integer> countSymptoms(List<String> symptoms) {
		    Map<String, Integer> counts = new HashMap<>();
		    for (String symptom : symptoms) {
		        counts.put(symptom, counts.getOrDefault(symptom, 0) + 1);
		    }
		    return counts;
		}
	 
	 
	 
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
	    return new TreeMap<>(symptoms);
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
	    writer.writeSymptoms(symptoms);
	}
	
}
