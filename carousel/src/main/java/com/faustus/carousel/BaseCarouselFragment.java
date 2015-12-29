package com.faustus.carousel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by flux on 12/29/15.
 */
public abstract class BaseCarouselFragment extends Fragment
{
    protected CarouselDelegate delegate;
    protected BaseCarouselAdapter mAdapter;
    protected Fragment fragment;
    protected static String FRAGMENT_KEY_="FRAGMENT_KEY";
    protected CarouselLayout mCarousel;


    public void show(FragmentManager manager, int ContainerId)
    {
        delegate.show(manager, ContainerId);

    }

}
