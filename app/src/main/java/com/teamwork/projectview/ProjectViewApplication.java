package com.teamwork.projectview;

import android.app.Application;

import com.teamwork.projectview.di.components.DaggerNetworkServiceComponent;
import com.teamwork.projectview.di.components.DaggerProjectComponent;
import com.teamwork.projectview.di.components.NetworkServiceComponent;
import com.teamwork.projectview.di.components.ProjectComponent;
import com.teamwork.projectview.di.module.ApplicationModule;
import com.teamwork.projectview.di.module.NetworkServiceModule;
import com.teamwork.projectview.di.module.ProjectModule;
import com.teamwork.projectview.di.module.RetrofitModule;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class is a custom application which uses Dagger to build the dependencies
 *
 * Created by Thulio Araujo on 3/4/2018.
 */

public class ProjectViewApplication extends Application {

    public ProjectComponent mProjectComponent;
    private NetworkServiceComponent mNetworkServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkServiceComponent = DaggerNetworkServiceComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkServiceModule(new NetworkServiceModule())
                .build();

        mProjectComponent = DaggerProjectComponent.builder()
                .networkServiceComponent(mNetworkServiceComponent)
                .retrofitModule(new RetrofitModule())
                .projectModule(new ProjectModule(this))
                .build();
    }

    public ProjectComponent getProjectComponent() {
        return mProjectComponent;
    }

    public NetworkServiceComponent getNetworkServiceComponent() {
        return mNetworkServiceComponent;
    }
}
