package com.rambler.belevtsevdaniil.model.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniil Belevtsev on 30.04.2016 19:58.
 * Project: fasten-customer-android; Visit www.fasten.com
 */
@Root(name = "rss")
public class RssModel {
    @Element(name = "channel")
    private ChannelModel channel;

    public ChannelModel getChannel() {
        return channel;
    }
}
