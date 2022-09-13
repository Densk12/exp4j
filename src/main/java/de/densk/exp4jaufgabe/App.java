package de.densk.exp4jaufgabe;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final HashMap<String, Double> variables = new HashMap<>();

            while (true) {
                System.out.print("> ");
                String expression = scanner.nextLine();

                // Input is exit
                if (expression.equals("exit")) {
                    break;
                }

                // Input is only a digit
                if (expression.matches(Regex.REGEX_ONLY_DIGIT.getRegex())) {
                    System.out.printf("%s%n", expression);
                    continue;
                }

                // Input is variable assignment
                if (expression.matches(Regex.REGEX_VARIABLE_ASSIGNMENT_OPTION_1.getRegex()) ||
                        expression.matches(Regex.REGEX_VARIABLE_ASSIGNMENT_OPTION_2.getRegex())
                ) {
                    final var splitted = expression.split("=");
                    final var variable = splitted[0].trim();
                    var valueStr = splitted[1].trim();
                    double value = 0.0;

                    if (valueStr.matches(Regex.REGEX_ARITH_EXPRESSION_WITHOUT_VARIABLES.getRegex())) {
                        value = new ExpressionBuilder(valueStr).build().evaluate();
                    } else {
                        value = Double.parseDouble(valueStr);
                    }

                    variables.put(variable, value);

                    System.out.printf("%s%n", value);

                    continue;
                }

                // Input is term expression
                double result = 0.0;

                try {
                    final Expression ex = new ExpressionBuilder(expression)
                            .variables(variables.keySet())
                            .build();

                    for (final var variable : variables.keySet()) {
                        ex.setVariable(variable, variables.get(variable));
                    }

                    result = ex.evaluate();
                } catch (Exception e) {
                    System.out.println("Fehler! Tachenrechner startet neu!");
                    System.out.println();

                    variables.clear();
                    continue;
                }

                variables.clear();
                System.out.println(result);
            }
        }
    }
}
