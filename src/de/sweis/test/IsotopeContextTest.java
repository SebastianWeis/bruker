package de.sweis.test;

import de.sweis.context.Context;
import de.sweis.context.IsotopeContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class IsotopeContextTest {
    private List<String> testList;
    private Context isotopeContext;

    @BeforeEach
    public void setup() {
        testList = Arrays.asList("29Si", "77Se", "199Hg", "171Yb", "75As", "97Mo", "201Hg", "95Mo", "67Zn", "25Mg");
        isotopeContext = new IsotopeContext(testList);
    }

    @Test
    public void testIncludeValues() {
        List<String> sublist = testList.subList(3, 5);
        isotopeContext.includeValues(sublist);
        assertEquals(sublist, isotopeContext.getSolution(), "Solution didn't equal included sublist");
        List<String> garbageList = Arrays.asList("dasd", "asdas");
        isotopeContext.includeValues(garbageList);
        assertFalse(isotopeContext.getSolution().contains(garbageList), "Solution contained values that are not in original list");

    }


    @Test
    public void testExcludeValues() {
        List<String> excludeSublist = testList.subList(2, 4);
        isotopeContext.includeValues(testList);
        isotopeContext.excludeValues(excludeSublist);
        for (String isotope : isotopeContext.getSolution()) {
            assertTrue(testList.contains(isotope) && !excludeSublist.contains(isotope), "Solution included value that was excluded");
        }
    }

    @Test
    public void testGetValuesInRange() {
        assertEquals(testList.subList(1, 4), isotopeContext.getValuesInRange(testList.get(1), testList.get(4 - 1)));
        assertEquals(testList.subList(3, testList.size()), isotopeContext.getValuesInRange(testList.get(testList.size() - 1), testList.get(3)));
    }
}
