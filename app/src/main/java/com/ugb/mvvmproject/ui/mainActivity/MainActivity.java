package com.ugb.mvvmproject.ui.mainActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.ugb.mvvmproject.R;
import com.ugb.mvvmproject.databinding.ActivityMainBinding;
import com.ugb.mvvmproject.ui.adapters.SliderPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    MainViewModel mainViewModel;
    SliderPagerAdapter sliderPagerAdapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);


        mainViewModel.mutableLiveData.observe(this,sliderModels -> {
            sliderPagerAdapter = new SliderPagerAdapter(this,sliderModels.getSlider().getSliderModels());
            mainBinding.viewPagerSlider.setAdapter(sliderPagerAdapter);
            mainBinding.springDotsIndicator.setViewPager(mainBinding.viewPagerSlider);
            sliderPagerAdapter.notifyDataSetChanged();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mainViewModel.getSlider();
    }
}