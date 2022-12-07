package de.sweis.expressions;

import de.sweis.context.Context;

import java.util.List;

public interface Expression {
    List<String> interpret(Context context);

}
