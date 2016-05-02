package com.rambler.belevtsevdaniil.presenter.presenters;

import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.model.Model;
import com.rambler.belevtsevdaniil.presenter.interfaces.Presenter;
import com.rambler.belevtsevdaniil.view.interfaces.View;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev on 30.04.2016 18:57.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public abstract class DefaultPresenter implements Presenter {

    @Inject
    protected Model model;

    @Inject
    protected CompositeSubscription compositeSubscription;

    public DefaultPresenter() {
        App.getComponent().inject(this);
    }

    protected void addSubscription(Subscription sub) {
        compositeSubscription.add(sub);
    }

    @Override
    public void onStop() {
        compositeSubscription.clear();
    }

    protected abstract View getView();
}
