package com.rambler.belevtsevdaniil.dagger;

import com.rambler.belevtsevdaniil.dagger.modules.ModelModule;
import com.rambler.belevtsevdaniil.dagger.modules.PresenterModule;
import com.rambler.belevtsevdaniil.dagger.modules.ViewModule;
import com.rambler.belevtsevdaniil.model.ModelImpl;
import com.rambler.belevtsevdaniil.presenter.presenters.DefaultPresenter;
import com.rambler.belevtsevdaniil.presenter.presenters.NewsListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniil Belevtsev on 30.04.2016 20:29.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ViewModule.class})
public interface AppComponent {

    void inject(ModelImpl dataRepository);

    void inject(DefaultPresenter defaultPresenter);

    void inject(NewsListPresenter newsListPresenter);
}
