package com.magictools.android.demo.imageslider;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;

import com.magictools.android.demo.R;

class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter
{
    protected static final String[] CONTENT = new String[] { "This", "Is", "A", "Test", };
    
    protected static final String[] CONTENTIMAGES = new String[] {
    	"This", 
    	"Is", 
    	"A", 
    	"Test"
    };

    protected static final int[] ICONS = new int[] {
            R.drawable.caricon,
    		R.drawable.caricon,
    		R.drawable.caricon,
    		R.drawable.caricon
    };
    
    private int mCount = CONTENT.length;

	//---------------
    public TestFragmentAdapter(FragmentManager fm)
	//---------------
    {
        super(fm);
    }

	//---------------
    @Override public Fragment getItem(int position)
	//---------------
    {
        return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
    }

	//---------------
    @Override public int getCount()
	//---------------
    {
        return mCount;
    }

	//---------------
    @Override public CharSequence getPageTitle(int position)
	//---------------
    {
      return TestFragmentAdapter.CONTENT[position % CONTENT.length];
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