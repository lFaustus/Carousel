package com.faustus.carousel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by flux on 12/29/15.
 */
public class CarouselDelegate
{
    private int mContainerId;
    private Fragment mfragment;

    protected CarouselDelegate(Fragment mfragment){
        this.mfragment = mfragment;
        //getContainerView();
    }

    public void show(FragmentManager fragmentManager,int mContainerId)
    {
        this.mContainerId = mContainerId;
        //fragmentManager.beginTransaction().add(mfragment,String.valueOf(mContainerId)).commit();
        //fragmentManager.beginTransaction().replace(mContainerId,mfragment).commit();
        final String fragmentTag = String.valueOf(mContainerId);
        final Fragment mfrag = fragmentManager.findFragmentByTag(fragmentTag);
        if(mfrag == null)
            fragmentManager.beginTransaction().add(mContainerId, mfragment, fragmentTag).commit();
        else
            fragmentManager.beginTransaction().remove(mfrag).commitAllowingStateLoss();

    }
    public static CarouselDelegate create(Fragment mfragment)
    {
        return new CarouselDelegate(mfragment);
    }


    /*private CarouselLayout findCarouselLayout()
    {
        Fragment parentFragment = mfragment.getParentFragment();
        if (parentFragment != null) {
            View view = parentFragment.getView();
            if (view != null) {
                return (CarouselLayout) view.findViewById(mCarouselId);
            } else {
                return null;
            }
        }
        Activity parentActivity = mfragment.getActivity();
        if (parentActivity != null) {
            return (CarouselLayout) parentActivity.findViewById(mCarouselId);
        }
        return null;
    }*/

    private View getContainerView()
    {
        Fragment parentFragment = mfragment.getParentFragment();
        if(parentFragment != null)
        {
            return parentFragment.getView();
        }

        AppCompatActivity parentActivity = (AppCompatActivity) mfragment.getActivity();
        if(parentActivity !=null)
        {
            return parentActivity.findViewById(mContainerId);
        }
        return null;
    }

}
