package org.daergaoth.model;

public class MalApiPictureResponse {
    String medium;
    String large;

    public MalApiPictureResponse(String medium, String large) {
        this.medium = medium;
        this.large = large;
    }

    public MalApiPictureResponse() {
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
