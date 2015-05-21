package com.magictools.android.demo.imageslider;

import com.viewpagerindicator.IconPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.magictools.android.demo.R;

public class PlaceSlidesFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter
{
	private int[] Images = new int[] {
		//R.drawable.car01,
	};

	protected static final int[] ICONS = new int[] { 
		R.drawable.caricon,
		R.drawable.caricon, 
		R.drawable.caricon, 
		R.drawable.caricon 
	};

	private int mCount = Images.length;

	//---------------
	public PlaceSlidesFragmentAdapter(FragmentManager fm)
	//---------------
	{
		super(fm);
	}

	//---------------
	@Override public Fragment getItem(int position)
	//---------------
	{
		return new PlaceSlideFragment(Images[position]);
	}

	//---------------
	@Override public int getCount()
	//---------------
	{
		return mCount;
	}

	//---------------
	@Override public int getIconResId(int index)
	//---------------
	{
		return ICONS[index % ICONS.length];
	}

	//---------------
	public void setCount(int count)
	//---------------
	{
		if (count > 0 && count <= 10)
		{
		    mCount = count;
		    notifyDataSetChanged();
		}
	}
}