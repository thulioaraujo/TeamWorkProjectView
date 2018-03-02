package com.teamwork.projectview.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the Category of a Project object of the
 * TeamWork API.
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public class Category {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("color")
    @Expose
    private String color;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Category() {
    }

    /**
     * 
     * @param id
     * @param color
     * @param name
     */
    public Category(String name, String id, String color) {
        super();
        this.name = name;
        this.id = id;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
