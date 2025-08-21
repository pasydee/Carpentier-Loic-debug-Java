package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines the contract for writing symptoms and their occurrence counts to an output destination (e.g., a file).
 * 
 * Implementations of this interface decide how and where the data is written.
 */
public interface ISymptomWriter {
	
	
	/**
     * Writes the provided symptoms and their occurrence counts
     *
     * @param symptoms a map containing the symptoms and their occurrence counts
     */
	void writeSymptoms(Map<String, Integer> symptoms);
}