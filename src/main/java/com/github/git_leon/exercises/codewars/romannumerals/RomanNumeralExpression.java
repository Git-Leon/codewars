package com.github.git_leon.exercises.codewars.romannumerals;

public class RomanNumeralExpression {
    private final String expression;

    public RomanNumeralExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public Integer getValue() {
        Integer totalValue = 0;
        for(String currentNumeralCharacter : expression.split("")) {
            // if `currentNumeralCharacter` is followed by a `RomanNumeralCharacter` of lesser value, then
            // sum each of the lesser values that follow it, and
            // subtract that sum
            totalValue += RomanNumeralCharacter.valueOf(currentNumeralCharacter.toUpperCase()).getValue();

        }
        return totalValue;
    }
}
