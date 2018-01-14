package com.example.asus.stock_control.webService;

import com.example.asus.stock_control.gsonbean.EmployeeAddGsonBean;
import com.example.asus.stock_control.gsonbean.ProductCategoryBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by asus on 2018/1/13.
 */

public interface ProductCategoryServices {
    @POST("")
    Call<ProductCategoryBean> getEmployeeAddServices(@Query("TableName") String Employee_info);
}
