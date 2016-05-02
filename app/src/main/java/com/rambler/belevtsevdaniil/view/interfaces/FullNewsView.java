package com.rambler.belevtsevdaniil.view.interfaces;

import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;

/**
 * Created by Daniil Belevtsev on 02.05.2016 4:53.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public interface FullNewsView extends View {
    void showNewsItem(NewsItem item);
    void showEmptyItem();
}
