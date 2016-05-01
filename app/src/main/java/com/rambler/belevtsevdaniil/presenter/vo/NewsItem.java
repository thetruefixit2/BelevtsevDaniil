package com.rambler.belevtsevdaniil.presenter.vo;

import com.rambler.belevtsevdaniil.model.dto.ElementDTO;

/**
 * Created by Daniil Belevtsev on 01.05.2016 1:59.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class NewsItem {

    private String provider;
    private String publishDate;
    private String title;
    private String description;
    private String link;
    private NewsImage image;

    public NewsItem(String provider, String publishDate, String title, NewsImage image, String description, String link) {
        this.provider = provider;
        this.publishDate = publishDate;
        this.title = title;
        this.image = image;
        this.description = description;
        this.link = link;
    }

    public NewsItem(String provider, ElementDTO element) {
        this.provider = provider;
        this.publishDate = element.getPublishDate();
        this.title = element.getTitle();
        this.image = new NewsImage(element.getEnclosure());
        this.description = element.getDescription();
        this.link = element.getLink();
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

    public String getLink() {
        return link;
    }

    public NewsImage getImage() {
        return image;
    }
}
