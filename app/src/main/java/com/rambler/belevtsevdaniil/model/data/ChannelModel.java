package com.rambler.belevtsevdaniil.model.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Daniil Belevtsev on 30.04.2016 19:18.
 * Project: fasten-customer-android; Visit www.fasten.com
 */
@Root(name = "channel")
public class ChannelModel {
    @Element(name = "title")
    private String title;

    @Element(name = "copyright")
    private String copyright;

    @ElementList(name = "item")
    private List<ElementModel> newsFeed;

    public String getTitle() {
        return title;
    }

    public String getCopyright() {
        return copyright;
    }

    public List<ElementModel> getNewsFeed() {
        return newsFeed;
    }
}
