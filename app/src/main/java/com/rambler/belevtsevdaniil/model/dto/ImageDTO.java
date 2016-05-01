package com.rambler.belevtsevdaniil.model.dto;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Daniil Belevtsev on 01.05.2016 1:25.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */

@Root(name = "enclosure")
public class ImageDTO {

    @Attribute(name = "length")
    private String length;

    @Attribute(name = "type")
    private String type;

    @Attribute(name = "url")
    private String url;

    public String getLength() {
        return length;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
