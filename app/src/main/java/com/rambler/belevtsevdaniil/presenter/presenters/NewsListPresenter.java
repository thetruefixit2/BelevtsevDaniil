package com.rambler.belevtsevdaniil.presenter.presenters;

import android.os.Bundle;

import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.presenter.mappers.RssNewsMapper;
import com.rambler.belevtsevdaniil.presenter.vo.NewsItem;
import com.rambler.belevtsevdaniil.view.interfaces.NewsListView;
import com.rambler.belevtsevdaniil.view.interfaces.View;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

/**
 * Created by Daniil Belevtsev on 01.05.2016 22:14.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class NewsListPresenter extends DefaultPresenter {

    @Inject
    protected RssNewsMapper rssMapper;

    private NewsListView view;

    private List<NewsItem> newsFeed;

    @Inject
    public NewsListPresenter() {
    }

    public NewsListPresenter(NewsListView view) {
        App.getComponent().inject(this);
        this.view = view;
    }

    @Override
    protected View getView() {
        return view;
    }

    public void loadNews() {
        Subscription sub = Observable.merge(model.getGazetaChannel(), model.getLentaChannel())
                .map(rssMapper)
                .subscribe(new Observer<List<NewsItem>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<NewsItem> newsItems) {
                        if(newsItems != null && !newsItems.isEmpty()) {
                            newsFeed = newsItems;
                            view.showLastNews(newsItems);
                        } else {
                            view.showEmptyNews();
                        }
                    }
                });
        addSubscription(sub);
    }

    @SuppressWarnings("unchecked")
    public void onCreateView(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            newsFeed = (List<NewsItem>) savedInstanceState.getSerializable(AppConst.SERIALIZABLE_NEWS_BUNDLE);
        }
    }



}
