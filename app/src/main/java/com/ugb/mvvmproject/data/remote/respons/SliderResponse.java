package com.ugb.mvvmproject.data.remote.respons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ugb.mvvmproject.data.models.Slider;

public class SliderResponse extends RootResponse {

    @SerializedName("data")
    @Expose
    Slider slider;

    public Slider getSlider() {
        return slider;
    }
}
