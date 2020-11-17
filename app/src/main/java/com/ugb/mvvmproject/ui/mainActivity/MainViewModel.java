package com.ugb.mvvmproject.ui.mainActivity;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ugb.mvvmproject.data.remote.respons.SliderResponse;
import com.ugb.mvvmproject.data.remote.ApiClient;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends ViewModel {
    MutableLiveData<SliderResponse> mutableLiveData = new MutableLiveData<>();

    @SuppressLint("CheckResult")
    public void getSlider() {
        Single<SliderResponse> observableLogin = ApiClient.getINSTANCE().getSlider()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observableLogin.subscribe(o -> mutableLiveData.setValue(o), e -> Log.d("getSliderError", e + ""));


    }
}
