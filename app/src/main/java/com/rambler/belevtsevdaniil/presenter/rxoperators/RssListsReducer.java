package com.rambler.belevtsevdaniil.presenter.rxoperators;

import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Func2;

/**
 * Created by Daniil Belevtsev on 02.05.2016 18:35.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class RssListsReducer implements Func2<List<NewsItem>, List<NewsItem>, List<NewsItem>> {

    @Inject
    public RssListsReducer() {
    }

    @Override
    public List<NewsItem> call(List<NewsItem> newsItems, List<NewsItem> newsItems2) {
        newsItems.addAll(newsItems2);
        return newsItems;
    }
}
