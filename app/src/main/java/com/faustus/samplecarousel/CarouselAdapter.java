package com.faustus.samplecarousel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.faustus.carousel.BaseCarouselAdapter;
import com.faustus.carousel.CarouselItemLayout;

import java.util.List;

public class CarouselAdapter extends BaseCarouselAdapter<String>
{

	public CarouselAdapter(FragmentManager fm, List<String> mData)
	{
		super(fm, mData);
	}

	@Override
	public Fragment getItem(int position) 
	{
        // make the first pager bigger than others
        if (position == super.FIRST_PAGE)
        	scale = CarouselItemLayout.BIG_SCALE;
        else
        	scale = CarouselItemLayout.SMALL_SCALE;
        
        position = position % super.PAGES;
        return CarouselItem.newInstance(mData.get(position),scale);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) 
	{	
		if (positionOffset >= 0f && positionOffset <= 1f)
		{
		        cur = getRootView(position);
        		cur.setScaleBoth(CarouselItemLayout.BIG_SCALE - CarouselItemLayout.DIFF_SCALE * positionOffset);

        		//if (position < CarouselActivity.PAGES-1) {
        			next = getRootView(position +1);
        			next.setScaleBoth(CarouselItemLayout.SMALL_SCALE + CarouselItemLayout.DIFF_SCALE * positionOffset);
        		//}
		}
	}

	@Override
	public void onPageSelected(int position) {}
	
	@Override
	public void onPageScrollStateChanged(int state) {}

}
