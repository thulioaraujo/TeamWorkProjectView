package com.teamwork.projectview.model.dao;

import com.teamwork.projectview.model.entities.Projects;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represts the Project DAO which retrieves data from
 * the TeamWorkAPI
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

public interface ProjectDAO {

    @GET("/projects.json?status=ALL")
    Observable<Projects> getAllProject();

}
