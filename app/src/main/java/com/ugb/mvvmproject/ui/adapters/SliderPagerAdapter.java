package com.ugb.mvvmproject.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.ugb.mvvmproject.R;
import com.ugb.mvvmproject.data.models.SliderModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Waseem on 11/22/2016.
 */

public class SliderPagerAdapter extends PagerAdapter {
    List<SliderModel> data;
    private LayoutInflater layoutInflater;
    Context context;

    public SliderPagerAdapter(Context context, List<SliderModel> data) {
        this.data = data;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = layoutInflater.inflate(R.layout.item_slider_home_page, container, false);
        ImageView imageSlider = v.findViewById(R.id.imageSlider);
        Glide.with(context)
                .load(data.get(position).getImage())
                .centerCrop()
                .placeholder(R.drawable.image_slider)
                .into(imageSlider);
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
