package com.rambler.belevtsevdaniil.view.callbacks;

import com.rambler.belevtsevdaniil.presenter.beans.NewsItem;

/**
 * Created by Daniil Belevtsev on 02.05.2016 3:05.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public interface OnNewsListEventsListener extends OnProgressListener {
    void showFullNews(NewsItem item);
}
