package com.teamwork.projectview.data.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the list of Projects object of the
 * TeamWork API.
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public class Projects {

    @SerializedName("STATUS")
    @Expose
    private String status;
    @SerializedName("projects")
    @Expose
    private List<Project> projects = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Projects() {
    }

    /**
     * 
     * @param projects
     * @param status
     */
    public Projects(String status, List<Project> projects) {
        super();
        this.status = status;
        this.projects = projects;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
