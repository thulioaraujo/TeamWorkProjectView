package com.teamwork.projectview.di.components;

import com.teamwork.projectview.di.module.ApplicationModule;
import com.teamwork.projectview.di.module.NetworkServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * TeamWorkProjectView - Technical Test
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

@Singleton
@Component(modules={ApplicationModule.class, NetworkServiceModule.class})
public interface NetworkServiceComponent {

    Retrofit retrofit();
}
