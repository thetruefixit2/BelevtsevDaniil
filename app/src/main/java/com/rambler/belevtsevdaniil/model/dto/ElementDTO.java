package com.rambler.belevtsevdaniil.model.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniil Belevtsev on 30.04.2016 20:03.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Root(name = "item", strict = false)
public class ElementDTO {

    @Element(name = "pubDate")
    private String publishDate;

    @Element(name = "title")
    private String title;

    @Element(name = "enclosure", required = false)
    private ImageDTO enclosure;

    @Element(name = "description", data = true, required = false)
    private String description;


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

}
