package com.rambler.belevtsevdaniil.presenter.beans;

import com.rambler.belevtsevdaniil.model.dto.ElementDTO;
import com.rambler.belevtsevdaniil.utils.TimeFormat;

import org.joda.time.DateTime;

import java.io.Serializable;


/**
 * Created by Daniil Belevtsev on 01.05.2016 1:59.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */

public class NewsItem implements Serializable {

    private NewsProvider provider;
    private DateTime publishDate;
    private String title;
    private String description;
    private NewsImage image;


    public NewsItem(NewsProvider provider, ElementDTO element) {
        this.provider = provider;
        if(element.getPublishDate() != null) {
            this.publishDate = TimeFormat.format(element.getPublishDate());
        }
        this.title = element.getTitle();
        this.description = element.getDescription();
        if(element.getEnclosure() != null) {
            this.image = new NewsImage(element.getEnclosure());
        }
    }

    public NewsProvider getProvider() {
        return provider;
    }

    public DateTime getPublishDate() {
        return publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public NewsImage getImage() {
        return image;
    }
}
