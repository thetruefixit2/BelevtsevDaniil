package com.rambler.belevtsevdaniil.model.dto;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Daniil Belevtsev on 30.04.2016 19:58.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
@Root(name = "rss")
public class RssDTO {
    @Element(name = "channel")
    private ChannelDTO channel;

    public ChannelDTO getChannel() {
        return channel;
    }
}
