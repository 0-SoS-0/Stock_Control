package com.example.asus.stock_control.webAPI;

import com.example.asus.stock_control.webService.ProductAddServices;
import com.example.asus.stock_control.webService.ProductDeleteServices;

import retrofit2.Retrofit;

/**
 * Created by asus on 2018/1/13.
 */

public class ProductDeleteAPI extends webapi{
    String url="http://123.207.36.208:8080/user/";
    Retrofit retrofit=getApi(url);

    @Override
    public <T> T getService() {
        return (T) retrofit.create(ProductDeleteServices.class);
    }
}
