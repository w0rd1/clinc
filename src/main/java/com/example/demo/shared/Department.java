package com.example.demo.shared;

public enum Department {

    EMERGENCY("EMERGENCY"),
    CARDIOLOGY("CARDIOLOGY"),
    NEUROLOGY("NEUROLOGY"),
    ORTHOPEDICS("ORTHOPEDICS"),
    RADIOLOGY("RADIOLOGY"),
    ONCOLOGY("ONCOLOGY"),
    PEDIATRICS("PEDIATRICS"),
    GYNECOLOGY("GYNECOLOGY"),
    UROLOGY("UROLOGY"),
    DERMATOLOGY("DERMATOLOGY"),
    ANESTHESIOLOGY("ANESTHESIOLOGY"),
    ICU("ICU"),
    GENERAL_SURGERY("GENERAL_SURGERY"),
    OPHTHALMOLOGY("OPHTHALMOLOGY"),
    ENT("ENT"); // Ear, Nose, Throat

    private final String value;

    Department(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
