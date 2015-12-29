package com.faustus.samplecarousel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.faustus.carousel.CarouselDelegate;
import com.faustus.carousel.CarouselLayout;

import java.util.ArrayList;

/**
 * Created by flux on 12/29/15.
 */
public class BaseCarouselFragment_backup extends Fragment
{
    private CarouselDelegate delegate;
    private CarouselAdapter mAdapter;
    private Fragment fragment;
    protected static String FRAGMENT_KEY_="FRAGMENT_KEY";
    private CarouselLayout mCarousel;


    public static BaseCarouselFragment_backup newInstance()
    {
        Bundle args = new Bundle();
        BaseCarouselFragment_backup fragment = new BaseCarouselFragment_backup();
        args.putString(FRAGMENT_KEY_,fragment.getClass().getName());
        fragment.setArguments(args);
        return fragment;
    }
    public BaseCarouselFragment_backup()
    {
        delegate = CarouselDelegate.create(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        /*FrameLayout mLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams mParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mParams.gravity = Gravity.CENTER;
        mLayout.setLayoutParams(mParams);
        mLayout.setBackgroundColor(ContextCompat.getColor(getContext(),android.R.color.transparent));*/
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_carousel_layout,container,false);
        mCarousel = (CarouselLayout) v.findViewById(R.id.carousel_layout);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        ArrayList<String> mlist = new ArrayList<>();
        mlist.add("one");
        mlist.add("two");
        mlist.add("three");
        mlist.add("four");

        mAdapter = new CarouselAdapter(getFragmentManager(),mlist);
        mCarousel.setCarouselAdapter(mAdapter);
        mCarousel.setCurrentItem(mAdapter.FIRST_PAGE);
        mCarousel.setOffScreenPageLimit(3);
        mCarousel.setPageMargin(-200);
    }


    public void show(FragmentManager manager, int ContainerId)
    {
        delegate.show(manager, ContainerId);

    }

}
