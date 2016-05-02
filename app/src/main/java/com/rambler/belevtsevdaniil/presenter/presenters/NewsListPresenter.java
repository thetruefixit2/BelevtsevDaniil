package com.rambler.belevtsevdaniil.presenter.presenters;

import android.os.Bundle;

import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.presenter.mappers.RssNewsMapper;
import com.rambler.belevtsevdaniil.view.interfaces.NewsListView;
import com.rambler.belevtsevdaniil.view.interfaces.View;

import org.parceler.Parcels;

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

    @Override
    protected View getView() {
        return view;
    }

    public void init(NewsListView view) {
        App.getComponent().inject(this);
        this.view = view;
    }

    public void loadNews() {
        Subscription sub = Observable.merge(model.getLentaChannel(), model.getGazetaChannel())
                .map(rssMapper)
                .subscribe(new Observer<List<NewsItem>>() {
                    @Override
                    public void onCompleted() {
                        view.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
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

    public void onCreateView(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            newsFeed = Parcels.unwrap(savedInstanceState.getParcelable(AppConst.EXTRA_NEWS_FEED));
        }
        if(isNotEmptyFeed()) {
            view.showLastNews(newsFeed);
        } else {
            loadNews();
        }
    }

    public void saveInstanceState(Bundle outState) {
        if(isNotEmptyFeed()) {
            outState.putParcelable(AppConst.EXTRA_NEWS_FEED, Parcels.wrap(newsFeed));
        }
    }


    private boolean isNotEmptyFeed() {
        return newsFeed != null && !newsFeed.isEmpty();
    }
}
