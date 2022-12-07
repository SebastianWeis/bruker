package de.sweis;

import de.sweis.parser.MalformedQueryException;
import de.sweis.solver.IsotopeQuerySolver;
import de.sweis.solver.QuerySolver;

import java.util.Scanner;

public class TerminalQueryApplication {
    private QuerySolver querySolver;

    public TerminalQueryApplication(QuerySolver querySolver) {
        this.querySolver = querySolver;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a query:");
            String query = scanner.nextLine();
            try {
                System.out.println("Solution: " + querySolver.solveQuery(query));
            } catch (MalformedQueryException e) {
                System.out.println("Error while parsing query: " + e.getMessage());
            }
        }
    }
}
