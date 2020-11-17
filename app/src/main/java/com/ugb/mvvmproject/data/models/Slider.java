package com.ugb.mvvmproject.data.models;

import java.util.ArrayList;
import java.util.List;

public class Slider {

    List<SliderModel> sliders = new ArrayList<>();
    int notifications_count;

    public List<SliderModel> getSliderModels() {
        return sliders;
    }

    public int getNotifications_count() {
        return notifications_count;
    }

}
