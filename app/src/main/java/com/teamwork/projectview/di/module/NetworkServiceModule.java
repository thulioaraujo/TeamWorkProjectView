package com.teamwork.projectview.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * TeamWorkProjectView - Technical Test
 *
 * This class represents the network connection to the
 * TeamWork API to retrieve data from it's webservice
 *
 * Created by Thulio Araujo on 3/1/2018.
 */

@Module
public class NetworkServiceModule {

    private final String authKey = "dHdwX1RFYkJYR0NudmwySGZ2WFdma0xVbHp4OTJlM1Q6eWF0eWF0eWF0Mjc=";
    private static final String BASE_URL = "https://yat.teamwork.com/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Authorization", "BASIC " + authKey)
                        .addHeader("Accept", "application/json");

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
