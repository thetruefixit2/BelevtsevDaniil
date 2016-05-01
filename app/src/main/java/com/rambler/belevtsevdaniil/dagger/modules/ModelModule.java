package com.rambler.belevtsevdaniil.dagger.modules;

import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.model.api.NetworkModule;
import com.rambler.belevtsevdaniil.model.api.interfaces.GazetaApi;
import com.rambler.belevtsevdaniil.model.api.interfaces.LentaApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
* Created by Daniil Belevtsev on 30.04.2016 22:39.
        * Project: BelevtsevDaniil; Skype: pandamoni1
        */
@Module
public class ModelModule {

    @Provides @Singleton
    GazetaApi provideGazetaApi() {
        return NetworkModule.getGazetaApiInterface(AppConst.GAZETA_URL);
    }

    @Provides @Singleton
    LentaApi provideLentaApi() {
        return NetworkModule.getLentaApiInterface(AppConst.LENTA_URL);
    }

    @Provides @Singleton
    @Named(AppConst.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides @Singleton
    @Named(AppConst.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }
}
