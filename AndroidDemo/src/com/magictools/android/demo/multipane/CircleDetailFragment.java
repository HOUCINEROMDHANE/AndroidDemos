package com.magictools.android.demo.multipane;

import com.magictools.android.demo.R;
import com.magictools.android.demo.R.id;
import com.magictools.android.demo.R.layout;
import com.magictools.android.demo.multipane.DummyContent.DummyItem;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Circle detail screen. This fragment is
 * either contained in a {@link CircleListActivity} in two-pane mode (on
 * tablets) or a {@link CircleDetailActivity} on handsets.
 */
public class CircleDetailFragment extends Fragment
{
	public static CircleDetailFragment fa;
	
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	View rootView = null;
	
	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public CircleDetailFragment()
	{
		
	}
	
	//---------------
	@Override public void onCreate(Bundle savedInstanceState)
	//---------------
	{
		System.out.println("--- CircleDetailFragment.onCreate ---");
		
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID))
		{
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
		}
		
		fa = this;
	}

	//-------------------
    void registerClickCallback()
	//-------------------
    {
    	Button btn_back = (Button) rootView.findViewById(R.id.btn_back);
    	
    	btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
            	getActivity().finish();
            }
        });
	}

	//---------------
	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	//---------------
	{
		rootView = inflater.inflate(R.layout.fragment_circle_detail, container, false);

		registerClickCallback();
		
		// Show the dummy content as text in a TextView.
		if (mItem != null)
		{
//			if (CircleListActivity.mTwoPane)
//			{
//				Button myButton = ((Button) rootView.findViewById(R.id.btn_back));
//				myButton.setVisibility(View.GONE);
//			    ViewGroup.LayoutParams params = myButton.getLayoutParams();
//			    params.width = LayoutParams.MATCH_PARENT;
//			    myButton.setLayoutParams(params);
//			}
//			else
//			{
//				Button myButton = ((Button) rootView.findViewById(R.id.btn_back));
//				myButton.setVisibility(View.VISIBLE);
//			    ViewGroup.LayoutParams params = myButton.getLayoutParams();
//			    params.width = LayoutParams.WRAP_CONTENT;
//			    myButton.setLayoutParams(params);
//			}
			
			if (CircleListActivity.mTwoPane)
			{
				Button myButton = ((Button) rootView.findViewById(R.id.btn_back));
				myButton.setVisibility(View.GONE);
			}
			else
			{
				Button myButton = ((Button) rootView.findViewById(R.id.btn_back));
				myButton.setVisibility(View.VISIBLE);
			}

			((TextView) rootView.findViewById(R.id.main_screen_btn_header)).setText(mItem.content);
			((ImageView) rootView.findViewById(R.id.circle_view)).setImageResource(mItem.resourceId);
		}

		return rootView;
	}
}
