package com.example.lyp.lppkaoshi1.api;

import com.example.lyp.lppkaoshi1.beans.MyBeans;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MySerive {

    //https://api.apiopen.top/getJoke
    public String url="https://api.apiopen.top/";

    @GET("getJoke")
    Observable<MyBeans> getData();

}
