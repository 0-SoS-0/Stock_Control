package com.example.asus.stock_control.webService;

import com.example.asus.stock_control.gsonbean.EmployeeAddGsonBean;
import com.example.asus.stock_control.gsonbean.EmployeeDeleteGsonBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by asus on 2018/1/13.
 */

public interface EmployeeDeleteServices {
    @POST("")
    Call<EmployeeDeleteGsonBean> getEmployeeDeleteServices(@Query("TableName") String Employee_info,
                                                           @Query("employeeNo") String employeeNo

    );
}
