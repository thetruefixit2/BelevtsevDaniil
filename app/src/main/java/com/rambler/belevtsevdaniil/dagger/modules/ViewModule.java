package com.rambler.belevtsevdaniil.dagger.modules;

import com.rambler.belevtsevdaniil.presenter.presenters.FullNewsPresenter;
import com.rambler.belevtsevdaniil.presenter.presenters.NewsListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 30.04.2016 22:39.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Module
public class ViewModule {
    @Provides
    NewsListPresenter provideNewsListPresenter() {
        return new NewsListPresenter();
    }

    @Provides
    FullNewsPresenter provideFullNewsPresenter() {
        return new FullNewsPresenter();
    }
}
