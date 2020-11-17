package com.ugb.mvvmproject.data.remote;

import com.ugb.mvvmproject.data.remote.respons.SliderResponse;
import com.ugb.mvvmproject.data.remote.respons.UserResponse;

import java.util.HashMap;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface DataClient {
    @POST("login")
    public Single<UserResponse> logIn(@Body HashMap<Object, Object> user);

    @GET("sliders")
    public Single<SliderResponse> getSlider(@Header("Authorization") String token);

}
