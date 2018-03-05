package com.teamwork.projectview.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the Company object of the
 * TeamWork API.
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public class Company {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is-owner")
    @Expose
    private String isOwner;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Company() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param isOwner
     */
    public Company(String name, String isOwner, String id) {
        super();
        this.name = name;
        this.isOwner = isOwner;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
