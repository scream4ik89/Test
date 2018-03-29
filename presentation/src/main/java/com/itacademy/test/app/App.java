package com.itacademy.test.app;

import android.app.Application;

import com.itacademy.test.injection.AppComponent;
import com.itacademy.test.injection.AppModule;
import com.itacademy.test.injection.DaggerAppComponent;

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}