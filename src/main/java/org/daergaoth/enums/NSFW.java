package org.daergaoth.enums;

public enum NSFW {
    WHITE("white"),
    GRAY("gray"),
    BLACK("black");

    private final String label;

    private NSFW(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
