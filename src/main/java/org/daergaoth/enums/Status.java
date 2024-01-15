package org.daergaoth.enums;

public enum Status {
    FINISHED_AIRING("finished_airing"),
    CURRENTLY_AIRING("currently_airing"),
    NOT_YET_AIRED("not_yet_aired");

    private final String label;

    private Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
