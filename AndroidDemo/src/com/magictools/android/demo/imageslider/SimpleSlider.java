package com.magictools.android.demo.imageslider;

import java.io.IOException;

import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import com.magictools.android.demo.R;

public class SimpleSlider extends Activity
{
    private class ImagePagerAdapter extends PagerAdapter
    {
        private final String[] mImages2 = new String[] {
            "img/cars/car01.jpg",
            "img/cars/car02.jpg",
            "img/cars/car03.jpg",
            "img/cars/car04.jpg",
            "img/cars/car05.jpg",
            "img/cars/car06.jpg",
            "img/cars/car07.jpg",
            "img/cars/car08.jpg",
            "img/cars/car09.jpg",
            "img/cars/car10.jpg",
            "img/cars/car11.jpg"
        };

        private final int[] mImages = new int[] {
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
        		R.drawable.caricon,
            };

        //---------------
        @Override public void destroyItem(final ViewGroup container, final int position, final Object object)
    	//---------------
        {
            ((ViewPager) container).removeView((ImageView) object);
        }

    	//---------------
        @Override public int getCount()
    	//---------------
        {
            return this.mImages2.length;
        }

    	//---------------
        @Override public Object instantiateItem(final ViewGroup container, final int position)
    	//---------------
        {
            final Context context = SimpleSlider.this;
            final ImageView imageView = new ImageView(context);
            final int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            
            //imageView.setImageResource(this.mImages[position]);

			try {
				imageView.setImageBitmap(BitmapFactory.decodeStream(getAssets().open(this.mImages2[position])));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

    	//---------------
        @Override public boolean isViewFromObject(final View view, final Object object)
    	//---------------
        {
            return view == ((ImageView) object);
        }
    }
 
	//---------------
    @Override public void onCreate(final Bundle savedInstanceState)
	//---------------
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_circles);

		registerClickCallback();

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        final ImagePagerAdapter adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);

        final CirclePageIndicator circleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);

        final TextView tvText = (TextView) findViewById(R.id.text);
        tvText.setText("Hello People!");

//        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        final ImagePagerAdapter adapter = new ImagePagerAdapter();
//        viewPager.setAdapter(adapter);
//
//        final CirclePageIndicator circleIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
//        circleIndicator.setViewPager(viewPager);
//
//        //final TextView tvText = (TextView) findViewById(R.id.text);
//        //tvText.setText(getResources().getString(R.string.bodyText));
    }
    
	//-------------------
    void registerClickCallback()
	//-------------------
    {
    	Button btn_back = (Button) findViewById(R.id.btn_back);
    	
    	btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
            	finish();
            }
        });
	}
}