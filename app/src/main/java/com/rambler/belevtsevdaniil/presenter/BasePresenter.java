package com.rambler.belevtsevdaniil.presenter;

import com.rambler.belevtsevdaniil.presenter.interfaces.PresenterInterface;

import rx.Subscription;

/**
 * Created by Daniil Belevtsev on 30.04.2016 18:57.
 * Project: fasten-customer-android; Visit www.fasten.com
 */
public class BasePresenter implements PresenterInterface {

    protected void addSub(Subscription sub) {

    }

    @Override
    public void onClose() {

    }
}
