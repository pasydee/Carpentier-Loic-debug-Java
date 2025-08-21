package com.hemebiotech.analytics;

import java.util.List;

/**
 * Defines the contract for reading symptom data from a data source.
 * <p>
 * The result is a list of strings representing symptoms. The list:
 * <ul>
 *   <li>may contain duplicate entries</li>
 *   <li>is not guaranteed to be ordered</li>
 *   <li>will be empty if no data is available</li>
 * </ul>
 * Implementations of this interface specify the actual source 
 * (e.g., a file, a database, or an API).
 */
public interface ISymptomReader {

    /**
     * Retrieves a raw list of symptoms from the data source.
     *
     * @return a list of symptoms as strings. 
     *         The list may contain duplicates or be empty if no data is found.
     */
    List<String> getSymptoms();
}
