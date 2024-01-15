package org.daergaoth.enums;

public enum Source {
    OTHER("other"),
    ORIGINAL("original"),
    MANGA("manga"),
    KOMA_MANGA("4_koma_manga"),
    WEB_MANGA("web_manga"),
    DIGITAL_MANGA("digital_manga"),
    NOVEL("novel"),
    LIGHT_NOVEL("light_novel"),
    VISUAL_NOVEL("visual_novel"),
    GAME("game"),
    CARD_GAME("card_game"),
    BOOK("book"),
    PICTURE_BOOK("picture_book"),
    RADIO("radio"),
    MUSIC("music");

    private final String label;

    private Source(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
