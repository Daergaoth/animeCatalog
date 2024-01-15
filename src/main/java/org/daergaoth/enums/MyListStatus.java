package org.daergaoth.enums;

public enum MyListStatus {

    WATCHING("watching"),
    COMPLETED("completed"),
    ON_HOLD("on_hold"),
    DROPPED("dropped"),
    PLAN_TO_WATCH("plan_to_watch");

    private final String label;

    private MyListStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
