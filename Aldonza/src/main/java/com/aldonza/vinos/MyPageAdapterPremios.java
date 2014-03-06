package com.aldonza.vinos;


import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

public class MyPageAdapterPremios extends PagerAdapter {
    //---return the total number of pages---
    private int resId;
    private View view;
    private int number;
    @Override
    public int getCount() {
        return number;
    }
    public void setN(int N) {
        this.number = N;
    }
    public Object instantiateItem(View collection, int position) {
        //ImageInflater inf = (ImageInflater)collection.getContext().getSystemService(Context.)
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (collection.getId()){
            case R.id.viewPagerPremios:
                resId = 0;
                switch (position) {
                    case 0:
                        resId = R.layout.premio1;
                        break;
                    case 1:
                        resId = R.layout.premio3;
                        break;
                    case 2:
                        resId = R.layout.premio2;
                        break;
                    case 3:
                        resId = R.layout.premio4;
                        break;
                }
            view = inflater.inflate(resId, null);
            ((ViewPager) collection).addView(view, 0);
                break;
            case R.id.viewPagerPisces:
                resId = 0;
                switch (position) {
                    case 0:
                        resId = R.layout.premio1pisces;
                        break;
                    case 1:
                        resId = R.layout.premio2pisces;
                        break;
                    case 2:
                        resId = R.layout.premio3pisces;
                        break;
                    case 3:
                        resId = R.layout.premio4pisces;
                        break;
                    case 4:
                        resId = R.layout.premio5pisces;
                        break;
                    case 5:
                        resId = R.layout.premio6pisces;
                        break;

                }
                view = inflater.inflate(resId, null);
                ((ViewPager) collection).addView(view, 0);
                break;
        }
        return view;
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}

