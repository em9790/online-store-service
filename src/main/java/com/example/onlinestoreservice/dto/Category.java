package com.example.onlinestoreservice.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Category extends EntityBase {

    private String name;
    private String description;
    @Column(name="image_url")
    private String imageURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", active=" + isActive() +
                ", regDate=" + getRegDate() +
                '}';
    }
}
