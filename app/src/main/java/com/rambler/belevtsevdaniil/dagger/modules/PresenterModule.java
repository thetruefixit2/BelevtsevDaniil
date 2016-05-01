package com.rambler.belevtsevdaniil.dagger.modules;

import com.rambler.belevtsevdaniil.model.Model;
import com.rambler.belevtsevdaniil.model.ModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev on 30.04.2016 22:39.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Module
public class PresenterModule {

    @Provides @Singleton
    Model provideData() {
        return new ModelImpl();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }
}
