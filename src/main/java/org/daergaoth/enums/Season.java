package org.daergaoth.enums;

public enum Season {
    WINTER("winter"),
    SPRING("spring"),
    SUMMER("summer"),
    FALL("fall");

    private final String label;

    private Season(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
