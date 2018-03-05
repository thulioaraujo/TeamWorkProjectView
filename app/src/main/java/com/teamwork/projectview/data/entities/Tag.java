package com.teamwork.projectview.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the Tags of a project
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public class Tag {

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
    public Tag() {
    }

    /**
     * 
     * @param id
     * @param color
     * @param name
     */
    public Tag(String name, String id, String color) {
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
