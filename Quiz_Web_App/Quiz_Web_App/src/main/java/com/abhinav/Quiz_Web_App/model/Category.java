package com.abhinav.Quiz_Web_App.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String Discriptions;
    private String SubCategories;

    public Category(){

    }

    public Category(int id, String title, String discriptions, String subCategories) {
        this.id = id;
        this.title = title;
        Discriptions = discriptions;
        SubCategories = subCategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscriptions() {
        return Discriptions;
    }

    public void setDiscriptions(String discriptions) {
        Discriptions = discriptions;
    }

    public String getSubCategories() {
        return SubCategories;
    }

    public void setSubCategories(String subCategories) {
        SubCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Discriptions='" + Discriptions + '\'' +
                ", SubCategories=" + SubCategories +
                '}';
    }
}
