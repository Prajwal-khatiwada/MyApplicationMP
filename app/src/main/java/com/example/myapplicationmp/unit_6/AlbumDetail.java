package com.example.myapplicationmp.unit_6;

public class AlbumDetail {
    private final int image;
    private final String title;
    private final String description;

    public AlbumDetail(String n, String d, int i) {

        this.image = i;
        this.title = n;
        this.description = d;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
