package com.faustus.carousel;

import android.util.Log;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


import java.util.List;

public class BaseCarouselAdapter<T> extends FragmentPagerAdapter implements
		ViewPager.OnPageChangeListener {
    protected int PAGES;
    // You can choose a bigger number for LOOPS, but you know, nobody will fling
    // more than 1000 times just in order to test your "infinite" ViewPager :D
    public int LOOPS = 1000;
    public int FIRST_PAGE;

    protected CarouselItemLayout cur = null;
    protected CarouselItemLayout next = null;
    protected FragmentManager fm;
    protected float scale;
    protected List<T> mData;


	public BaseCarouselAdapter(FragmentManager fm, List<T> mData) {
		super(fm);
		this.fm = fm;
	    this.mData = mData;
        PAGES = mData.size();
        Log.e("pages",mData.size()+"");
        FIRST_PAGE = PAGES * LOOPS / 2;
	}


    @Override
	public Fragment getItem(int position)
	{
        // make the first pager bigger than others
      /*  if (position == CarouselItemLayout.FIRST_PAGE)
        	scale = CarouselItemLayout.BIG_SCALE;
        else
        	scale = CarouselItemLayout.SMALL_SCALE;

        position = position % CarouselItemLayout.PAGES;
       return CarouselItem.newInstance(mData.get(position));*/
        return null;

	}

	@Override
	public int getCount()
	{		
		/*return CarouselItemLayout.PAGES * CarouselItemLayout.LOOPS;*/
        return PAGES * LOOPS;
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

	public void setList(List<T> mData)
	{
        this.mData = mData;
        notifyDataSetChanged();
	}


	protected CarouselItemLayout getRootView(int position)
	{
		Log.e("fmname",fm.findFragmentByTag(this.getFragmentTag(position)).getClass().getSimpleName());
		return (CarouselItemLayout)
				fm.findFragmentByTag(this.getFragmentTag(position))
				.getView().findViewById(R.id.carousel_item);
	}

    protected String getFragmentTag(int position)
	{
	    return "android:switcher:"+ R.id.carousel_pager + ":"+ position;
	}

}
