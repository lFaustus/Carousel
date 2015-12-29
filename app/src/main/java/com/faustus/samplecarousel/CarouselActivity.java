package com.faustus.samplecarousel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CarouselActivity extends AppCompatActivity implements View.OnClickListener
{

	

	/*public ViewPager pager;*/


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button mbutton = (Button) findViewById(R.id.button);
		mbutton.setOnClickListener(this);
		//if(savedInstanceState == null)
			//getSupportFragmentManager().beginTransaction().replace(R.id.container,CarouselFragment.newInstance()).commit();
			//

		/*pager = (ViewPager) findViewById(R.id.myviewpager);

		mAdapter = new CarouselAdapter(this, this.getSupportFragmentManager());
		pager.setAdapter(mAdapter);
		pager.setOnPageChangeListener(mAdapter);
		
		
		// Set current item to the middle page so we can fling to both
		// directions left and right
		pager.setCurrentItem(FIRST_PAGE);
		
		// Necessary or the pager will only have one extra page to show
		// make this at least however many pages you can see
		pager.setOffscreenPageLimit(3);
		
		// Set margin for pages as a negative number, so a part of next and 
		// previous pages will be showed
		pager.setPageMargin(-200);*/

	}

	@Override
	public void onClick(View v)
	{

		CarouselFragment.newInstance().show(getSupportFragmentManager(),R.id.container);
	}




	/*public void setCarouselAdapter(CarouselAdapter adapter)
	{
		mAdapter = adapter;
	}*/
}
