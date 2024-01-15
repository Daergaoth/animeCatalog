package org.daergaoth.enums;

public enum MediaType {
    UNKNOWN("unknown"),
    TV("tv"),
    OVA("ova"),
    MOVIE("movie"),
    SPECIAL("special"),
    ONA("ona"),
    MUSIC("music");

    private final String label;

    private MediaType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
