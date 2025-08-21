package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The {@code AnalyticsCounter} class orchestrates the entire workflow:
 * <ul>
 *   <li>Reading symptoms from a source using an {@link ISymptomReader}</li>
 *   <li>Counting the occurrences of each symptom</li>
 *   <li>Sorting symptoms alphabetically</li>
 *   <li>Writing the results using an {@link ISymptomWriter}</li>
 * </ul>
 */
public class AnalyticsCounter {
	
    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Constructs a new {@code AnalyticsCounter}.
     *
     * @param reader an implementation of {@link ISymptomReader} used to read symptoms
     * @param writer an implementation of {@link ISymptomWriter} used to write the results
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Retrieves the list of symptoms using the {@link ISymptomReader}.
     *
     * @return a list of strings representing the symptoms read from the source
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the number of occurrences for each symptom in the provided list.
     *
     * @param symptoms the list of symptoms to be analyzed
     * @return a map where the key is the symptom and the value is its number of occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> counts = new HashMap<>();
        for (String symptom : symptoms) {
            counts.put(symptom, counts.getOrDefault(symptom, 0) + 1);
        }
        return counts;
    }

    /**
     * Sorts the symptoms alphabetically by their name.
     *
     * @param symptoms a map of symptoms and their occurrence counts
     * @return a {@link TreeMap} containing the symptoms sorted in alphabetical order
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<>(symptoms);
    }

    /**
     * Writes the provided symptoms and their occurrence counts using the {@link ISymptomWriter}.
     *
     * @param symptoms a map containing the symptoms and their occurrence counts
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
