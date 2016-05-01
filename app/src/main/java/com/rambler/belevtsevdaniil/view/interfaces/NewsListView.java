package com.rambler.belevtsevdaniil.view.interfaces;

import com.rambler.belevtsevdaniil.presenter.vo.NewsItem;

import java.util.List;

/**
 * Created by Daniil Belevtsev on 01.05.2016 22:20.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public interface NewsListView extends View {

    void showLastNews(List<NewsItem> newsFeed);

    void showEmptyNews();

    void openAdditionalInfo();

}
