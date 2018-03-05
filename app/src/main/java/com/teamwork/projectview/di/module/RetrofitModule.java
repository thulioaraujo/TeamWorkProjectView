package com.teamwork.projectview.di.module;

import com.teamwork.projectview.data.dao.ProjectDAO;

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
public class RetrofitModule {

    @Provides
    public ProjectDAO providesTaskInterface(Retrofit retrofit) {
        return retrofit.create(ProjectDAO.class);
    }

}
