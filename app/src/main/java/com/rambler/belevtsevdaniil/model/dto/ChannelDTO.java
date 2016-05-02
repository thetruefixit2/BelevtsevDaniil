package com.rambler.belevtsevdaniil.model.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Daniil Belevtsev on 30.04.2016 19:18.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Root(name = "channel", strict = false)
public class ChannelDTO {
    @Element(name = "title")
    private String title;

    @ElementList(entry = "item", inline = true)
    private List<ElementDTO> newsFeed;

    public String getTitle() {
        return title;
    }

    public List<ElementDTO> getNewsFeed() {
        return newsFeed;
    }
}
