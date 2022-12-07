package de.sweis.context;

import java.util.ArrayList;
import java.util.List;

public class IsotopeContext implements Context {
    List<String> isotopes;
    List<String> includes;
    List<String> excludes;

    public IsotopeContext(List<String> isotopes) {
        this.isotopes = isotopes;
        this.includes = new ArrayList<>();
        this.excludes = new ArrayList<>();
    }

    @Override
    public void includeValues(List<String> includes) {
        this.includes.addAll(includes);
    }

    @Override
    public void excludeValues(List<String> excludes) {
        this.excludes.addAll(excludes);
    }

    @Override
    public List<String> getValuesInRange(String leftValue, String rightValue) {
        List<String> isotopeSubset = new ArrayList<>();
        int indexLeft = isotopes.indexOf(leftValue);
        int indexRight = isotopes.indexOf(rightValue);
        int start = Math.min(indexLeft, indexRight);
        int end = Math.max(indexLeft, indexRight);
        for (int i = start; i <= end; i++) {
            isotopeSubset.add(isotopes.get(i));
        }
        return isotopeSubset;
    }


    @Override
    public List<String> getSolution() {
        List<String> selection = isotopes.stream().filter(i -> !excludes.contains(i) && includes.contains(i)).toList();
        includes.clear();
        excludes.clear();
        return selection;

    }
}
