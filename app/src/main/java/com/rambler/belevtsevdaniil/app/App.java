package com.rambler.belevtsevdaniil.app;

import android.app.Application;

import com.rambler.belevtsevdaniil.dagger.AppComponent;
import com.rambler.belevtsevdaniil.dagger.DaggerAppComponent;

/**
 * Created by Daniil Belevtsev on 30.04.2016 20:16.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class App extends Application {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
    }
}
