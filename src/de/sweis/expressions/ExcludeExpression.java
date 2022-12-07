package de.sweis.expressions;

import de.sweis.context.Context;

import java.util.List;

public class ExcludeExpression implements Expression {
    private Expression value;


    public ExcludeExpression(Expression value) {
        this.value = value;
    }

    @Override
    public List<String> interpret(Context context) {
        List<String> childList = value.interpret(context);
        context.excludeValues(childList);
        return childList;
    }


}
