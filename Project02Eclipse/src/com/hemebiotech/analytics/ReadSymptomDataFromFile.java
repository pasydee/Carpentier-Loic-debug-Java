package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of {@link ISymptomReader} that reads symptom data from a plain text file.
 * <p>
 * Each line in the file represents a symptom. The resulting list:
 * <ul>
 *   <li>may contain duplicate entries (if the file has duplicates)</li>
 *   <li>is not guaranteed to be sorted</li>
 * </ul>
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filePath;

    /**
     * Constructs a reader that will read symptoms from the specified file.
     *
     * @param filePath the full or relative path to the file containing symptoms,
     *                 one symptom per line
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads all symptoms from the file.
     *
     * @return a list of symptoms read from the file. 
     *         If the file is empty or not found, an empty list is returned.
     */
    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<>();

        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line = reader.readLine();
                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
