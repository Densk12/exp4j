package de.densk.exp4jaufgabe;

public enum Regex {
    REGEX_VARIABLE_ASSIGNMENT_OPTION_1("[xyz]\\s?=\\s?[0-9]+"),
    REGEX_VARIABLE_ASSIGNMENT_OPTION_2("[xyz]\\s?=\\s?\\d+(\\.\\d+)?\\s?[+\\-*/%]\\s?\\d+(\\.\\d+)?"),
    REGEX_ONLY_DIGIT("[0-9]+"),
    REGEX_ARITH_EXPRESSION_WITHOUT_VARIABLES("\\d+(\\.\\d+)?\\s?[+\\-*/%]\\s?\\d+(\\.\\d+)?");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
