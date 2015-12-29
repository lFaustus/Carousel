package com.faustus.carousel;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by flux on 12/29/15.
 */
public class CarouselLayout extends FrameLayout
{
    private ViewPager mPager;
    public CarouselLayout(Context context)
    {
        super(context);
        init();
    }

    public CarouselLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public CarouselLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CarouselLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init()
    {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.carousel_viewpager,this,true);
        mPager = (ViewPager) v.findViewById(R.id.carousel_pager);
    }

    public void setCarouselAdapter(BaseCarouselAdapter adapter)
    {
        mPager.setAdapter(adapter);
        mPager.addOnPageChangeListener(adapter);
    }


    // Set current item to the middle page so we can fling to both
    // directions left and right
    public void setCurrentItem(int page)
    {
        mPager.setCurrentItem(page);
    }

    // Necessary or the pager will only have one extra page to show
    // make this at least however many pages you can see
    public void setOffScreenPageLimit(int offset)
    {

        mPager.setOffscreenPageLimit(offset);
    }

    // Set margin for pages as a negative number, so a part of next and
    // previous pages will be showed
    public void setPageMargin(int margin)
    {
        mPager.setPageMargin(margin);
    }



}
