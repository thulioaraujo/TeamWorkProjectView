package com.teamwork.projectview.data.dao;

import com.teamwork.projectview.data.entities.Projects;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the Project DAO which retrieves data from
 * the TeamWorkAPI
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public interface ProjectDAO {

    @GET("/projects.json?status=ALL")
    Observable<Projects> getAllProject();

}
