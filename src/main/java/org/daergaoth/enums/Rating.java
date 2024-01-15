package org.daergaoth.enums;

public enum Rating {

    G("g"),
    PG("pg"),
    PG_13("pg_13"),
    R("r"),
    R_PLUS("r+"),
    RX("rx");

    private final String label;

    private Rating(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
