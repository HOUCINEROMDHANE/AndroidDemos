package com.magictools.android.demo.phonecatalog;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.magictools.android.demo.R;
import com.magictools.android.demo.R.id;
import com.magictools.android.demo.R.layout;
import com.magictools.android.demo.phonecatalog.PhoneListViewActivity.MyListAdapter;
import com.magictools.android.demo.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PhoneDetailsActivity extends Activity
{
	public JSONObject currentPhone = null;
	public JSONObject phoneDetails = null;
	
	//-------------------
	@Override public void onCreate(Bundle savedInstanceState)
	//-------------------
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_details);
		
		Intent intent = getIntent();
		
		int phone_index = intent.getIntExtra("phone_index", 0);
		
		currentPhone = Phones.phoneDataList.get(phone_index);
		
		phoneDetails = Utils.loadJSONObjectFromAssets("phones/" + currentPhone.getString("id") + ".json");
		
		populateDetailView();
		registerClickCallback();
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
    
	//-------------------
	void populateDetailView()
	//-------------------
	{
		final JSONArray arrImages = phoneDetails.getJSONArray("images");
		
        // Read a Bitmap from Assets
        try
        {
        	//--- Main Image ---
            ((ImageView)findViewById(R.id.main_image)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(currentPhone.getString("imageUrl"))));
            
        	//--- Sub Images ---
            int l = arrImages.length();
            
        	((ImageView)findViewById(R.id.sub_image_1)).setVisibility(View.INVISIBLE);
        	((ImageView)findViewById(R.id.sub_image_2)).setVisibility(View.INVISIBLE);
        	((ImageView)findViewById(R.id.sub_image_3)).setVisibility(View.INVISIBLE);
        	((ImageView)findViewById(R.id.sub_image_4)).setVisibility(View.INVISIBLE);
        	((ImageView)findViewById(R.id.sub_image_5)).setVisibility(View.INVISIBLE);
        	
            if (l>=1)
            {
            	((ImageView)findViewById(R.id.sub_image_1)).setVisibility(View.VISIBLE);
            	((ImageView)findViewById(R.id.sub_image_1)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(0))));
            	
            	((ImageView)findViewById(R.id.sub_image_1)).setOnClickListener(
            		new View.OnClickListener()
            		{
            			@Override public void onClick(View v)
            			{
            				try
            				{
								((ImageView)findViewById(R.id.main_image)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(0))));
							}
            				catch (JSONException e)
            				{
								e.printStackTrace();
							}
            				catch (IOException e)
            				{
								e.printStackTrace();
							}
            			}
            		}
            	);
            }
            
            if (l>=2)
            {
            	((ImageView)findViewById(R.id.sub_image_2)).setVisibility(View.VISIBLE);
            	((ImageView)findViewById(R.id.sub_image_2)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(1))));
            	
            	((ImageView)findViewById(R.id.sub_image_2)).setOnClickListener(
            		new View.OnClickListener()
            		{
            			@Override public void onClick(View v)
            			{
            				try
            				{
								((ImageView)findViewById(R.id.main_image)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(1))));
							}
            				catch (JSONException e)
            				{
								e.printStackTrace();
							}
            				catch (IOException e)
            				{
								e.printStackTrace();
							}
            			}
            		}
            	);
            }
            
            if (l>=3)
            {
            	((ImageView)findViewById(R.id.sub_image_3)).setVisibility(View.VISIBLE);
            	((ImageView)findViewById(R.id.sub_image_3)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(2))));
            	
            	((ImageView)findViewById(R.id.sub_image_3)).setOnClickListener(
            		new View.OnClickListener()
            		{
            			@Override public void onClick(View v)
            			{
            				try
            				{
								((ImageView)findViewById(R.id.main_image)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(2))));
							}
            				catch (JSONException e)
            				{
								e.printStackTrace();
							}
            				catch (IOException e)
            				{
								e.printStackTrace();
							}
            			}
            		}
            	);
            }
            
            if (l>=4)
            {
            	((ImageView)findViewById(R.id.sub_image_4)).setVisibility(View.VISIBLE);
            	((ImageView)findViewById(R.id.sub_image_4)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(3))));
            	
            	((ImageView)findViewById(R.id.sub_image_4)).setOnClickListener(
            		new View.OnClickListener()
            		{
            			@Override public void onClick(View v)
            			{
            				try
            				{
								((ImageView)findViewById(R.id.main_image)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(3))));
							}
            				catch (JSONException e)
            				{
								e.printStackTrace();
							}
            				catch (IOException e)
            				{
								e.printStackTrace();
							}
            			}
            		}
            	);
            }
            
            if (l>=5)
            {
            	((ImageView)findViewById(R.id.sub_image_5)).setVisibility(View.VISIBLE);
            	((ImageView)findViewById(R.id.sub_image_5)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(4))));
            	
            	((ImageView)findViewById(R.id.sub_image_5)).setOnClickListener(
            		new View.OnClickListener()
            		{
            			@Override public void onClick(View v)
            			{
            				try
            				{
								((ImageView)findViewById(R.id.main_image)).setImageBitmap(BitmapFactory.decodeStream(getAssets().open(arrImages.getString(4))));
							}
            				catch (JSONException e)
            				{
								e.printStackTrace();
							}
            				catch (IOException e)
            				{
								e.printStackTrace();
							}
            			}
            		}
            	);
           }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
		//-- Fill Text ---
		String s = "";

		((TextView)findViewById(R.id.phone_name)).setText(currentPhone.getString("name"));
		((TextView)findViewById(R.id.phone_description)).setText(currentPhone.getString("snippet"));

		s = phoneDetails.getString("additionalFeatures");
		((TextView)findViewById(R.id.phone_additionalFeatures_detail)).setText((s.length()>0)?s:"N/A");
		
		s = phoneDetails.getJSONObject("android").getString("os");
		((TextView)findViewById(R.id.phone_android_os)).setText("os: " + ((s.length()>0)?s:"N/A"));
		
		s = phoneDetails.getJSONObject("android").getString("ui");
		((TextView)findViewById(R.id.phone_android_ui)).setText("ui: " + ((s.length()>0)?s:"N/A"));
	}
}
