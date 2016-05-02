package com.rambler.belevtsevdaniil.presenter.rxoperators;

import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev on 01.05.2016 1:32.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class NewsListMapper implements Func1<List<NewsItem>, List<NewsItem>> {

    @Inject
    public NewsListMapper() {
    }

    @Override
    public List<NewsItem> call(List<NewsItem> newsItems) {
        List<NewsItem> newsItemList = Observable.from(newsItems)
                .toSortedList((item, item2) -> {
                    return item2.getPublishDate().compareTo(item.getPublishDate());
                })
                .toBlocking()
                .first();
        return newsItemList;
    }
}
