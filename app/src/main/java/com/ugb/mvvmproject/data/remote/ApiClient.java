package com.ugb.mvvmproject.data.remote;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.ugb.mvvmproject.data.local.SharedPreference;
import com.ugb.mvvmproject.data.remote.respons.SliderResponse;
import com.ugb.mvvmproject.data.remote.respons.UserResponse;
import com.ugb.mvvmproject.helper.GlobalConstants;

import java.util.HashMap;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient extends Application {
    private static final String BASE_URL = GlobalConstants.SERVER_URL_BASE;
    private DataClient dataClient;
    private static ApiClient INSTANCE;
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        dataClient = retrofit.create(DataClient.class);
    }

    public static ApiClient getINSTANCE() {
        if (null == INSTANCE) {

            INSTANCE = new ApiClient();
        }
        return INSTANCE;
    }

    public Single<UserResponse> login(HashMap<Object, Object> userData) {
        return dataClient.logIn(userData);
    }

    public Single<SliderResponse> getSlider() {
        Log.d("Token_User",SharedPreference.getInstance(mContext).getToken());
        return dataClient.getSlider(SharedPreference.getInstance(mContext).getToken());
    }
}
