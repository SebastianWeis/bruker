package de.sweis.solver;

import de.sweis.context.Context;
import de.sweis.context.IsotopeContext;
import de.sweis.expressions.Expression;
import de.sweis.parser.Parser;
import de.sweis.parser.ParserImpl;

import java.util.List;

/**
 * A {@code QuerySolver} that solves a query for a given subset of isotopes
 */
public class IsotopeQuerySolver implements QuerySolver {
    private Parser parser;
    private Context context;

    public IsotopeQuerySolver(List<String> isotopes) {
        this.parser = new ParserImpl();
        this.context = new IsotopeContext(isotopes);

    }

    @Override
    public List<String> solveQuery(String query) {
        Expression expression = parser.parse(query);
        return expression.interpret(context);
    }
}
