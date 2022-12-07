package de.sweis.expressions;

import de.sweis.context.Context;

import java.util.List;

public class IncludeExpression implements Expression {
    private Expression value;

    public IncludeExpression(Expression value) {
        this.value = value;
    }

    @Override
    public List<String> interpret(Context context) {
        List<String> childList = value.interpret(context);
        context.includeValues(childList);
        return childList;

    }
}
