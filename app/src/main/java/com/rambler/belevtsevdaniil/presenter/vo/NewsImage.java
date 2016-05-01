package com.rambler.belevtsevdaniil.presenter.vo;

import com.rambler.belevtsevdaniil.model.dto.ImageDTO;

/**
 * Created by Daniil Belevtsev on 01.05.2016 2:00.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public class NewsImage {
    private String type;
    private String url;

    public NewsImage(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public NewsImage(ImageDTO element) {
        this.type = element.getType();
        this.url = element.getUrl();
    }
}
