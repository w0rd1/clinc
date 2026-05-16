package com.example.demo.shared;

public enum SurgeryStatus {
    IN_PROGRESS("in progress"),
    FINISHED("finished"),
    NOT_START("not start");

    private final String value;
    SurgeryStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
