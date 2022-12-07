package de.sweis.expressions;

import de.sweis.context.Context;

import java.util.List;

public class TopExpression implements Expression {
    private List<Expression> expressions;

    public TopExpression(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public List<String> interpret(Context context) {
        for (Expression e : expressions) {
            e.interpret(context);
        }
        return context.getSolution();
    }


}
