package com.rambler.belevtsevdaniil.model.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniil Belevtsev on 30.04.2016 20:03.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Root(name = "item")
public class ElementDTO {
    @Element(name = "guid")
    private String id;

    @Element(name = "pubDate")
    private String publishDate;

    @Element(name = "title")
    private String title;

    @Element(name = "enclosure", required = false)
    private ImageDTO enclosure;

    @Element(name = "description")
    private String description;

    @Element(name = "link")
    private String link;

    public String getId() {
        return id;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getTitle() {
        return title;
    }

    public ImageDTO getEnclosure() {
        return enclosure;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}
