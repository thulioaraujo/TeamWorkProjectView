package com.teamwork.projectview.model.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the Defaults object of the
 * TeamWork API.
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public class Defaults {

    @SerializedName("privacy")
    @Expose
    private String privacy;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Defaults() {
    }

    /**
     * 
     * @param privacy
     */
    public Defaults(String privacy) {
        super();
        this.privacy = privacy;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

}
