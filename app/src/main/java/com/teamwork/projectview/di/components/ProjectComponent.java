package com.teamwork.projectview.di.components;

import com.teamwork.projectview.di.module.ProjectModule;
import com.teamwork.projectview.di.module.RetrofitModule;
import com.teamwork.projectview.di.scope.ActivityScoped;
import com.teamwork.projectview.ui.project.ProjectActivity;

import dagger.Component;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/4/2018.
 */

@ActivityScoped
@Component(dependencies = NetworkServiceComponent.class, modules = {RetrofitModule.class, ProjectModule.class})
public interface ProjectComponent {

    void inject(ProjectActivity projectActivity);

}
