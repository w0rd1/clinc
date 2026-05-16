package com.example.demo.shared;

public enum Surgeon {

    LEAD_SURGEON("LEAD_SURGEON"),
    CARDIAC_SURGEON("CARDIAC_SURGEON"),
    NEUROSURGEON("NEUROSURGEON");

    private final String value;

    Surgeon(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
