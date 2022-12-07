package de.sweis.test;

import de.sweis.context.Context;
import de.sweis.context.IsotopeContext;
import de.sweis.expressions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionsTest {

    private List<String> testList;
    private Context isotopeContext;

    @BeforeEach
    public void setup() {
        testList = Arrays.asList("159Tb", "69Ga", "121Sb", "59Co", "187Re", "103Rh", "155Gd", "167Er", "41K", "179Hf");
        isotopeContext = new IsotopeContext(testList);
    }

    @Test
    public void testSingleElementExpression() {
        Expression exp = new SingleElementExpression(testList.get(3));
        assertEquals(testList.subList(3, 4), exp.interpret(isotopeContext));
    }

    @Test
    public void testRangeExpression() {
        Expression exp = new RangeExpression(testList.get(0), testList.get(3));
        assertEquals(testList.subList(0, 4), exp.interpret(isotopeContext));

        exp = new RangeExpression(testList.get(4), testList.get(2));
        assertEquals(testList.subList(2, 5), exp.interpret(isotopeContext));
    }

    @Test
    public void testIncludeExpression() {
        Expression exp = new IncludeExpression(new SingleElementExpression(testList.get(2)));
        exp.interpret(isotopeContext);

        assertEquals(testList.subList(2, 3), isotopeContext.getSolution());

        exp = new IncludeExpression(new RangeExpression(testList.get(2), testList.get(testList.size() - 1)));
        exp.interpret(isotopeContext);
        assertEquals(testList.subList(2, testList.size()), isotopeContext.getSolution());

    }

    @Test
    public void testExcludeExpression() {
        Expression includeExpression = new IncludeExpression(new RangeExpression(testList.get(0), testList.get(5)));
        includeExpression.interpret(isotopeContext);
        Expression exludeExpression = new ExcludeExpression(new RangeExpression(testList.get(0), testList.get(3)));
        exludeExpression.interpret(isotopeContext);

        assertEquals(testList.subList(4, 6), isotopeContext.getSolution());


    }
}
