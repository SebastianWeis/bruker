package de.sweis.expressions;

import de.sweis.context.Context;

import java.util.List;

public class RangeExpression implements Expression {
    String leftValue, rightValue;

    public RangeExpression(String leftValue, String rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    @Override
    public List<String> interpret(Context context) {
        return context.getValuesInRange(leftValue,rightValue);
    }

}
