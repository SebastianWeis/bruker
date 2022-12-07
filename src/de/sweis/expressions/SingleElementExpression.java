package de.sweis.expressions;

import de.sweis.context.Context;

import java.util.Collections;
import java.util.List;

public class SingleElementExpression implements Expression {
    String value;

    public SingleElementExpression(String value) {
        this.value = value;
    }

    @Override
    public List<String> interpret(Context context) {
        return Collections.singletonList(value);
    }

}
