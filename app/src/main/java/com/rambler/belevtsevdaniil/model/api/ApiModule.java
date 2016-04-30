package com.rambler.belevtsevdaniil.model.api;

/**
 * Created by Daniil Belevtsev on 30.04.2016 13:18.
 * Project: fasten-customer-android; Visit www.fasten.com
 */
public class ApiModule {
    public static final String GAZETA_URL = "http://www.gazeta.ru";
    public static final String LENTA_URL = "https://lenta.ru";

//    public static GazetaInterface getGazetaModule() {
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(GAZETA_URL)
//                .addConverterFactory(SimpleXmlConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
//        return builder.build().create(GazetaInterface.class);
//    }
//
//    public static LentaInterface getLentaModule() {
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(LENTA_URL)
//                .addConverterFactory(SimpleXmlConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
//        return builder.build().create(LentaInterface.class);
//    }
}
