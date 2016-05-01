package com.rambler.belevtsevdaniil.model.api.interfaces;

import com.rambler.belevtsevdaniil.model.dto.RssDTO;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 30.04.2016 13:15.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */
public interface GazetaApi extends ApiInterface {
    @GET("/export/rss/lenta.xml")
    Observable<RssDTO> getGazetaRss();
}
