package com.rambler.belevtsevdaniil.dagger;

import com.rambler.belevtsevdaniil.dagger.modules.ModelModule;
import com.rambler.belevtsevdaniil.dagger.modules.PresenterModule;
import com.rambler.belevtsevdaniil.dagger.modules.ViewModule;
import com.rambler.belevtsevdaniil.model.ModelImpl;
import com.rambler.belevtsevdaniil.presenter.presenters.DefaultPresenter;
import com.rambler.belevtsevdaniil.presenter.presenters.FullNewsPresenter;
import com.rambler.belevtsevdaniil.presenter.presenters.NewsListPresenter;
import com.rambler.belevtsevdaniil.view.fragments.FullNewsFragment;
import com.rambler.belevtsevdaniil.view.fragments.NewsListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniil Belevtsev on 30.04.2016 20:29.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Singleton
@Component(modules = {ModelModule.class, PresenterModule.class, ViewModule.class})
public interface AppComponent {
    // Models
    void inject(ModelImpl dataRepository);
    // View
    void inject(NewsListFragment fragment);
    void inject(FullNewsFragment fragment);
    // Presenter
    void inject(DefaultPresenter defaultPresenter);
    void inject(NewsListPresenter newsListPresenter);
    void inject(FullNewsPresenter fullNewsPresenter);

}
