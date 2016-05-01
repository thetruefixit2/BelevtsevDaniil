package com.rambler.belevtsevdaniil.model.api;

import com.rambler.belevtsevdaniil.model.api.interfaces.GazetaApi;
import com.rambler.belevtsevdaniil.model.api.interfaces.LentaApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Daniil Belevtsev on 30.04.2016 13:18.
 * Project: BelevtsevDaniil; Skype: pandamoni1
 */

public class NetworkModule {

    public NetworkModule() {
    }

    public static GazetaApi getGazetaApiInterface(String url) {
        OkHttpClient client = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(client);
        return builder.build().create(GazetaApi.class);
    }

    public static LentaApi getLentaApiInterface(String url) {
        OkHttpClient client = new OkHttpClient();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(client);
        return builder.build().create(LentaApi.class);
    }
}

