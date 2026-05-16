package com.example.demo.shared;

public enum Staff {

    NURSE_A1("NURSE_A1"),
    NURSE_B2("NURSE_B2"),
    ANES_C1("ANES_C1"),
    TECH_D1("TECH_D1"),
    NURSE_E3("NURSE_E3");

    private final String value;

    Staff(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
