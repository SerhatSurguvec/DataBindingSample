package com.example.serhat.databindingex.Model;

/**
 * Created by Serhat on 01/12/15.
 */
public class Contact {
    private String name;
    private String surname;
    private String title;
    private String imageUrl;

    public Contact() {
    }

    public Contact(String name, String surname, String title, String imageUrl) {
        this.setName(name);
        this.setSurname(surname);
        this.setTitle(title);
        this.setImageUrl(imageUrl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
