package com.rambler.belevtsevdaniil.model.dto;

import com.rambler.belevtsevdaniil.presenter.beans.NewsProvider;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniil Belevtsev on 30.04.2016 19:58.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Root(name = "rss", strict = false)
public class RssDTO {

    @Element(name = "channel")
    private ChannelDTO channel;

    private NewsProvider provider;

    public ChannelDTO getChannel() {
        return channel;
    }

    public NewsProvider getProvider() {
        return provider;
    }

    public void setProvider(NewsProvider provider) {
        this.provider = provider;
    }
}
