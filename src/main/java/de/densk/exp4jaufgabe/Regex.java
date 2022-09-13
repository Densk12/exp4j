package de.densk.exp4jaufgabe;

public enum Regex {
    REGEX_VARIABLE_ASSIGNMENT_OPTION_1("^[xyz]\\s?=\\s?(0|-?([1-9]+0*)+)(\\.\\d+)?$"),
    REGEX_VARIABLE_ASSIGNMENT_OPTION_2("^[xyz]\\s?=\\s?(0|-?([1-9]+0*)+)(\\.\\d+)?\\s?[+\\-*/%]\\s?(0|-?([1-9]+0*)+)(\\.\\d+)?$"),
    REGEX_ONLY_DIGIT("^(0|-?([1-9]+0*)+)(\\.\\d+)?$"),
    REGEX_ARITH_EXPRESSION_WITHOUT_VARIABLES("^(0|-?([1-9]+0*)+)(\\.\\d+)?\\s?[+\\-*/%]\\s?(0|-?([1-9]+0*)+)(\\.\\d+)?$");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
