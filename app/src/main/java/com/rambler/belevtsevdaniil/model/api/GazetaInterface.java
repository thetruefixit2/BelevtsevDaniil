package com.rambler.belevtsevdaniil.model.api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 30.04.2016 13:15.
 * Project: fasten-customer-android; Visit www.fasten.com
 */
public interface GazetaInterface {
    @GET("/export/rss/lenta.xml")
    Observable<String> getGazetaRss();
}
