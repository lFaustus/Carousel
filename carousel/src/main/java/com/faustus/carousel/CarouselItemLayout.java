package com.faustus.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CarouselItemLayout extends LinearLayout {

	public final static float BIG_SCALE = 1.0f;
	public final static float SMALL_SCALE = 0.7f;
	public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

	private float scale = BIG_SCALE;
	//private ViewPager pager;

	public CarouselItemLayout(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public CarouselItemLayout(Context context) {
		super(context);
	}

	public void setScaleBoth(float scale)
	{
		this.scale = scale;
		this.invalidate(); 	// If you want to see the scale every time you set
							// scale you need to have this line here, 
							// invalidate() function will call onDraw(Canvas)
							// to redraw the view for you
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// The main mechanism to display scale animation, you can customize it
		// as your needs
		int w = this.getWidth();
		int h = this.getHeight();
		canvas.scale(scale, scale, w/2, h/2);
		
		super.onDraw(canvas);
	}
	/*private void setPager(Context context)
	{
		pager = new ViewPager(context);
		addView(pager);
	}*/
}
