package com.example.asus.stock_control.webService;

import com.example.asus.stock_control.gsonbean.ProductCategoryEditorGsonBean;
import com.example.asus.stock_control.gsonbean.PurchaseOrderEditorGsonBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by asus on 2018/1/13.
 */

public interface PurchaseOrderEditorServices {
    @POST("")
    Call<PurchaseOrderEditorGsonBean> getPurchaseOrderEditorServices(@Query("TableName") String PurchaseOrder_Info);
}
