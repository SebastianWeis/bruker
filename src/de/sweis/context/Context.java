package de.sweis.context;

import java.util.List;

public interface Context {
    /**
     * Includes the given values in the solution
     *
     * @param values The values to be included in the solution
     */
    void includeValues(List<String> values);

    /**
     * Excludes the given values from the solution
     *
     * @param values The values to be excluded from the solution
     */
    void excludeValues(List<String> values);

    /**
     * Calculates the solution based on the included and excluded values. Getting a solution resets the context
     *
     * @return the solution based on the included and excluded values
     */
    List<String> getSolution();

    List<String> getValuesInRange(String leftValue, String rightValue);

}
