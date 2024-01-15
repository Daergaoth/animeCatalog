package org.daergaoth.model;

public class MalApiNodeResponse {

    Long id;
    String title;
    MalApiPictureResponse main_picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MalApiPictureResponse getMain_picture() {
        return main_picture;
    }

    public void setMain_picture(MalApiPictureResponse main_picture) {
        this.main_picture = main_picture;
    }
}
