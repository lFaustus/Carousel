package com.faustus.carousel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

/**
 * Created by flux on 12/29/15.
 */
public abstract class BaseCarouselItem<T> extends Fragment
{
    protected static final String FRAGMENT_KEY_="FRAGMENT_KEY";
    protected String TAG;
    protected T item;
    protected float scale;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
            TAG = getArguments().getString(FRAGMENT_KEY_);
    }

    protected abstract void initializeViews(ViewGroup vg);

}
