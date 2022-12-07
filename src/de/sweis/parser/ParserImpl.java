package de.sweis.parser;

import de.sweis.expressions.*;


import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String RANGE_TOKEN = "-";
    private static final String EXCLUDE_START_TOKEN = "{";
    private static final String EXCLUDE_END_TOKEN = "}";
    private static final String SINGLE_TOKEN = "/";
    private List<Expression> expressionList;
    private StringBuilder queryBuilder;

    public ParserImpl() {
        expressionList = new ArrayList<>();
    }

    @Override
    public Expression parse(String query) {
        expressionList.clear();
        queryBuilder = new StringBuilder(query);
        parseExcludes();
        parseSingles();
        parseLast();


        return new TopExpression(expressionList);
    }

    private void parseExcludes() {
        while (queryBuilder.toString().contains(EXCLUDE_START_TOKEN)) {
            if (!queryBuilder.toString().contains(EXCLUDE_END_TOKEN)) {
                throw new MalformedQueryException("Query contained " + EXCLUDE_START_TOKEN + " but no " + EXCLUDE_END_TOKEN);
            }
            int start = queryBuilder.indexOf(EXCLUDE_START_TOKEN);
            int end = queryBuilder.indexOf(EXCLUDE_END_TOKEN) + 1;
            Expression expression = parseExcludeTerm(queryBuilder.substring(start, end));
            queryBuilder.delete(start, end);
            expressionList.add(expression);
        }
    }


    private void parseSingles() {
        while (queryBuilder.toString().contains(SINGLE_TOKEN)) {
            int start = queryBuilder.indexOf(SINGLE_TOKEN);
            queryBuilder.deleteCharAt(start);
            int end = queryBuilder.toString().contains(SINGLE_TOKEN) ? queryBuilder.indexOf(SINGLE_TOKEN) : queryBuilder.length();
            Expression expression = parseSingleTerm(queryBuilder.substring(start, end));
            queryBuilder.delete(start, end);
            expressionList.add(expression);
        }
    }

    private void parseLast() {
        if (!queryBuilder.isEmpty()) {
            expressionList.add(new IncludeExpression(parseLiteralTerm(queryBuilder.toString())));
        }
    }

    private Expression parseSingleTerm(String singleTerm) {
        return new IncludeExpression(parseLiteralTerm(singleTerm));
    }

    private Expression parseExcludeTerm(String excludeTerm) {

        excludeTerm = excludeTerm.replaceAll("[" + EXCLUDE_START_TOKEN + EXCLUDE_END_TOKEN + "]", "");
        return new ExcludeExpression(parseLiteralTerm(excludeTerm));

    }

    private Expression parseLiteralTerm(String literalTerm) {
        if (literalTerm.contains(RANGE_TOKEN)) {
            String[] splitTerm = literalTerm.split("-");
            return new RangeExpression(splitTerm[0], splitTerm[1]);
        } else {
            return new SingleElementExpression(literalTerm);
        }
    }
}
