package com.example.asus.stock_control.webAPI;

import retrofit2.Retrofit;

/**
 * Created by asus on 2018/1/13.
 */

public class ProductCategoryAPI extends webapi {
    String url="http://123.207.36.208:8080/user/";
    Retrofit retrofit=getApi(url);

    @Override
    public <T> T getService() {
        return (T) retrofit.create(ProductCategoryAPI.class);
    }
}
