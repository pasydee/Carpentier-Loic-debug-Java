package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

/**
 * An implementation of {@link ISymptomWriter} that writes symptoms and their occurrence counts 
 * to a text file.
 * <p>
 * Each line in the output file has the format:
 * <pre>
 * symptomName: count
 * </pre>
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    /**
     * Constructs a writer that will write symptoms to the specified file.
     *
     * @param filePath the full or relative path to the output file
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes all symptoms and their occurrence counts to the file.
     *
     * @param symptoms a map where the key is the symptom name and the value is its count
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (symptoms != null) {
            try (FileWriter writer = new FileWriter(filePath)) {
                Set<String> keys = symptoms.keySet();      
                for (String key : keys) {                   
                    int count = symptoms.get(key);          
                    writer.write(key + ": " + count + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
