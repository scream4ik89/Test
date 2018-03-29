package com.itacademy.test.injection;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itacademy.data.repository.GifRepositoryImpl;
import com.itacademy.data.rest.RestApi;
import com.itacademy.data.rest.RestService;
import com.itacademy.domain.executor.PostExecutionThread;
import com.itacademy.domain.repository.GifRepository;
import com.itacademy.test.BuildConfig;
import com.itacademy.test.executor.UIThread;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Context context;
    Retrofit retrofit;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return context;
    }

    @Provides
    @Singleton
    public PostExecutionThread getUiThread() {
        return new UIThread();
    }
    @Provides
    @Singleton
    public RestService getRestService(RestApi restAPI) {
        return new RestService(restAPI);
    }


    @Provides
    @Singleton
    public GifRepository getUserRepository(RestService restService) {
        return new GifRepositoryImpl(restService);
    }

    @Provides
    @Singleton
    public RestApi getRestApi(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson) {
       return new Retrofit.Builder()
               .baseUrl("http://api.giphy.com")
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .addConverterFactory(GsonConverterFactory.create(gson))
               .build();

    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                .create();
    }

}
