package com.rambler.belevtsevdaniil.model;

import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.model.api.interfaces.GazetaApi;
import com.rambler.belevtsevdaniil.model.api.interfaces.LentaApi;
import com.rambler.belevtsevdaniil.model.dto.RssDTO;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Daniil Belevtsev on 01.05.2016 0:43.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class ModelImpl implements Model {
    private final Observable.Transformer schedulersTransformer;

    @Inject
    protected GazetaApi gazetaApi;

    @Inject
    protected LentaApi lentaApi;

    @Inject
    @Named(AppConst.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(AppConst.IO_THREAD)
    Scheduler ioThread;


    public ModelImpl() {
        App.getComponent().inject(this);
        schedulersTransformer = o -> ((Observable)o).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }

    @Override
    public Observable<RssDTO> getGazetaChannel() {
        return gazetaApi
                .getGazetaRss()
                .compose(applySchedulers());
    }

    @Override
    public Observable<RssDTO> getLentaChannel() {
        return lentaApi
                .getLentaRss()
                .compose(applySchedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }
}
