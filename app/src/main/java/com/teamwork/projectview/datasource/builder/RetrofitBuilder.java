package com.teamwork.projectview.datasource.builder;

import com.teamwork.projectview.model.dao.ProjectDAO;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class provides the REST api for the interface needed
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

@Module
public class RetrofitBuilder {

    @Provides
    public ProjectDAO providesTaskInterface(Retrofit retrofit) {
        return retrofit.create(ProjectDAO.class);
    }

}
