package com.dnsoftindia.tesseractocrdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Ganesha on 1/8/2017.
 */

public class ImageAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Integer> imageIDs = new ArrayList<>();


    public ImageAdapter(Context context, ArrayList<Integer> imageIDs) {
        this.context = context;
        this.imageIDs = imageIDs;

    }

    @Override
    public int getCount() {
        return imageIDs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        RelativeLayout ll = new RelativeLayout(context);
        ll.setLayoutParams(new ViewGroup.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        ll.setGravity(Gravity.CENTER);


        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);
        imageView.setLayoutParams(lp);
        Glide.with(context)
                .load(imageIDs.get(position))
                .into(imageView);

        ll.addView(imageView);

        ((ViewPager) container).addView(ll, 0);
        return ll;
    }
}
