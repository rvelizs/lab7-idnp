package com.mv.lab07;

public class Building {
    private String imageUrl;
    private String title;
    private String category;
    private String description;

    public Building(String imageUrl, String title, String category, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.category = category;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
