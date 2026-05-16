package com.example.demo.shared;

public enum Surgery {

    APPENDECTOMY("APPENDECTOMY"),
    CHOLECYSTECTOMY("CHOLECYSTECTOMY"), // gallbladder removal
    HERNIA_REPAIR("HERNIA_REPAIR"),
    CARDIAC_BYPASS("CARDIAC_BYPASS"),
    ANGIOPLASTY("ANGIOPLASTY");

    private final String value;

    Surgery(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
