package com.example.asus.stock_control.webService;

import com.example.asus.stock_control.gsonbean.EmployeeAddGsonBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by asus on 2018/1/13.
 */

public interface EmployeeAddServices  {
    @POST("")
    Call<EmployeeAddGsonBean> getEmployeeAddServices(@Query("TableName") String Employee_info);
}
