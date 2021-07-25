package com.github.git_leon.codewars.codewars.romannumerals;

public enum RomanNumeralCharacter {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);


    private final Integer value;

    RomanNumeralCharacter(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
