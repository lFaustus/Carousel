package com.faustus.samplecarousel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faustus.carousel.BaseCarouselItem;
import com.faustus.carousel.CarouselItemLayout;

/**
 * Created by flux on 12/29/15.
 */
public class CarouselItem extends BaseCarouselItem<String>
{

   public static CarouselItem newInstance(String item,float scale)
   {
       Bundle args = new Bundle();
       CarouselItem fragment = new CarouselItem();
       args.putString(FRAGMENT_KEY_,fragment.getClass().getName());
       args.putString(CarouselItem.class.getSimpleName(),item);
       args.putFloat(CarouselItem.class.getSimpleName() + "scale", scale);
       fragment.setArguments(args);
       return fragment;
   }


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            super.item = getArguments().getString(CarouselItem.class.getSimpleName());
            super.scale = getArguments().getFloat(CarouselItem.class.getSimpleName() + "scale");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (container == null) {
            return null;
        }
        LinearLayout l = (LinearLayout)
                inflater.inflate(R.layout.fragment_carousel_item, container, false);



        CarouselItemLayout root = (CarouselItemLayout) l.findViewById(R.id.carousel_item);
        Log.e("scale",scale+"");
        root.setScaleBoth(super.scale);

        return l;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null)
            super.item = savedInstanceState.getString(CarouselItem.class.getSimpleName());

        TextView tv = (TextView) getView().findViewById(R.id.text);
        tv.setText(super.item);

    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(CarouselItem.class.getSimpleName(),super.item);
    }

    @Override
    protected void initializeViews(ViewGroup vg)
    {

    }
}
