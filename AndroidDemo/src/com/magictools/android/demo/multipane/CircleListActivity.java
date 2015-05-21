package com.magictools.android.demo.multipane;

import com.magictools.android.demo.R;
import com.magictools.android.demo.R.id;
import com.magictools.android.demo.R.layout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class CircleListActivity extends FragmentActivity implements CircleListFragment.Callbacks
{
	public static boolean mTwoPane;
	public String currentItemId = "";
	
	//---------------
	@Override protected void onCreate(Bundle savedInstanceState)
	//---------------
	{
		System.out.println("--- CircleListActivity.onCreate ---");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circle_list);
		
		registerClickCallback();

		if (findViewById(R.id.circle_detail_container) != null)
		{
			mTwoPane = true;
			((CircleListFragment) getSupportFragmentManager().findFragmentById(R.id.circle_list)).setActivateOnItemClick(true);
		}
		else
		{
			mTwoPane = false;
		}
	}
	
	//---------------
	@Override public void onItemSelected(String id)
	//---------------
	{
		currentItemId = id;
		selectItem(id);
	}
	
	//---------------
	public void selectItem(String id)
	//---------------
	{
		if (mTwoPane)
		{
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(CircleDetailFragment.ARG_ITEM_ID, id);
			CircleDetailFragment fragment = new CircleDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction().replace(R.id.circle_detail_container, fragment).commit();
		}
		else
		{
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, CircleDetailActivity.class);
			detailIntent.putExtra(CircleDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}
	}
	
//	//---------------
//    // Check screen orientation or screen rotate event here
//	//---------------
//    @Override public void onConfigurationChanged(Configuration newConfig)
//	//---------------
//    {
//		System.out.println("--- CircleListActivity.onConfigurationChanged ---");
//    	
//        super.onConfigurationChanged(newConfig);
//        
//		//CircleDetailActivity.fa.finish();
//		CircleDetailFragment.fa.getActivity().finish();
//		
//		if (findViewById(R.id.circle_detail_container) != null)
//		{
//			mTwoPane = true;
//		}
//		else
//		{
//			mTwoPane = false;
//		}
//
////        // Checks the orientation of the screen
////        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
////        {
////            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
////        }
////        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
////        {
////            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
////        }
//    }
    
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
