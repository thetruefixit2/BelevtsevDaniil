package com.rambler.belevtsevdaniil.presenter.beans;

import com.rambler.belevtsevdaniil.model.dto.ElementDTO;

import org.parceler.Parcel;

/**
 * Created by Daniil Belevtsev on 01.05.2016 1:59.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Parcel
public class NewsItem {

    private NewsProvider provider;
    private String publishDate;
    private String title;
    private String description;
    private NewsImage image;

    public NewsItem(NewsProvider provider, String publishDate, String title, NewsImage image, String description) {
        this.provider = provider;
        this.publishDate = publishDate;
        this.title = title;
        this.image = image;
        this.description = description;
    }

    public NewsItem(NewsProvider provider, ElementDTO element) {
        this.provider = provider;
        this.publishDate = element.getPublishDate();
        this.title = element.getTitle();
        if(element.getEnclosure() != null) {
            this.image = new NewsImage(element.getEnclosure());
        }
        this.description = element.getDescription();
    }

    public NewsProvider getProvider() {
        return provider;
    }

    public String getPublishDate() {
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
