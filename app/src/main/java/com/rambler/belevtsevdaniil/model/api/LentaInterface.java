package com.rambler.belevtsevdaniil.model.api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Daniil Belevtsev on 30.04.2016 13:16.
 * Project: fasten-customer-android; Visit www.fasten.com
 */
public interface LentaInterface {
    @GET("/rss")
    Observable<String> getLentaRss();
}
