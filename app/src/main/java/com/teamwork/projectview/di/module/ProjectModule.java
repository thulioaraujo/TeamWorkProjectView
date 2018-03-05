package com.teamwork.projectview.di.module;

import android.app.Application;

import com.teamwork.projectview.data.source.ProjectModel;
import com.teamwork.projectview.data.source.ProjectModelImpl;
import com.teamwork.projectview.ui.project.ProjectPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/4/2018.
 */

@Module
public class ProjectModule {

    private Application application;

    public ProjectModule(Application application) {
        this.application = application;
    }

    @Provides
    public ProjectPresenter getProjectPresenter(ProjectModel projectModel) {
        return new ProjectPresenter(application, projectModel);
    }

    @Provides
    ProjectModel providesProjectModel() {
        return new ProjectModelImpl(application);
    }
}
