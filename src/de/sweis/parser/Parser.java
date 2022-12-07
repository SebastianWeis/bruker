package de.sweis.parser;

import de.sweis.expressions.Expression;

public interface Parser {

    /**
     * Parses a query and returns the {@link Expression} contained in the given query
     *
     * @param query The query to be parsed
     * @return The {@code Expression} contained in the query
     */
    Expression parse(String query);
}
