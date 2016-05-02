package com.rambler.belevtsevdaniil.presenter.rxoperators;

import com.rambler.belevtsevdaniil.model.dto.RssDTO;
import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Daniil Belevtsev on 01.05.2016 1:32.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class RssNewsMapper implements Func1<RssDTO, List<NewsItem>> {

    @Inject
    public RssNewsMapper() {
    }

    @Override
    public List<NewsItem> call(RssDTO rssDTO) {
        if(rssDTO == null) {
            return null;
        }
        List<NewsItem> newsList = Observable
                .from(rssDTO.getChannel().getNewsFeed())
                .map(elementDTO -> new NewsItem(rssDTO.getProvider(), elementDTO))
                .toSortedList((item, item2) -> {
                    return item.getPublishDate().compareTo(item2.getPublishDate());
                })
                .toBlocking()
                .first();

        return newsList;
    }
}
