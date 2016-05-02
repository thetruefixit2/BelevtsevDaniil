package com.rambler.belevtsevdaniil.model;

import com.rambler.belevtsevdaniil.model.dto.RssDTO;

import rx.Observable;

/**
 * Created by Daniil Belevtsev on 30.04.2016 23:41.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public interface Model {
    Observable<RssDTO> getGazetaChannel();
    Observable<RssDTO> getLentaChannel();
}
