package com.rambler.belevtsevdaniil.presenter.presenters;

import android.os.Bundle;

import com.rambler.belevtsevdaniil.app.App;
import com.rambler.belevtsevdaniil.app.AppConst;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;
import com.rambler.belevtsevdaniil.view.interfaces.FullNewsView;
import com.rambler.belevtsevdaniil.view.interfaces.View;

/**
 * Created by Daniil Belevtsev on 02.05.2016 4:52.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class FullNewsPresenter extends DefaultPresenter {

    private FullNewsView view;

    private NewsItem newsItem;

    @Override
    protected View getView() {
        return view;
    }

    public void init(FullNewsView view, Bundle bundle) {
        App.getComponent().inject(this);
        this.view = view;
        readArguments(bundle);
    }

    public void onCreateView(Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            newsItem = (NewsItem) savedInstanceState.getSerializable(AppConst.EXTRA_NEWS_ITEM);
        }
        if(isNotEmpty()) {
            view.showNewsItem(newsItem);
        } else {
            view.showEmptyItem();
        }
    }

    public void saveInstanceState(Bundle outState) {
        if(isNotEmpty()) {
            outState.putSerializable(AppConst.EXTRA_NEWS_ITEM, newsItem);
        }
    }

    private void readArguments(Bundle bundle) {
        if(bundle != null) {
            newsItem = (NewsItem) bundle.getSerializable(AppConst.EXTRA_NEWS_ITEM);
        }
    }
    private boolean isNotEmpty() {
        return newsItem != null && newsItem.getDescription() != null && !newsItem.getDescription().isEmpty();
    }
}
