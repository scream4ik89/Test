package com.itacademy.test.injection;


import com.itacademy.test.presentation.screens.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(UserViewModel userViewModel);
}
