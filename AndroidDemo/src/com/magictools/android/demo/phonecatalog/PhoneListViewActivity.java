package com.magictools.android.demo.phonecatalog;

import org.json.JSONObject;

import com.magictools.android.demo.MainActivity;
import com.magictools.android.demo.R;
import com.magictools.android.demo.R.id;
import com.magictools.android.demo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PhoneListViewActivity extends Activity
{
	//-------------------
	@Override public void onCreate(Bundle savedInstanceState)
	//-------------------
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.phone_listview);
		
		populateListView();
		registerClickCallback();
	}
	
	//-------------------
	void populateListView()
	//-------------------
	{
		ArrayAdapter<JSONObject> adapter = new MyListAdapter();
		ListView listView = (ListView) findViewById(R.id.PhoneListView);
		listView.setAdapter(adapter);
	}
	
	//-------------------
    void registerClickCallback()
	//-------------------
    {
    	ListView listView = (ListView) findViewById(R.id.PhoneListView);
    	
    	listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				Intent i = new Intent(MainActivity.getInstance(), PhoneDetailsActivity.class);
				i.putExtra("phone_index", position);
				startActivity(i);
			}
    	});
    	
    	Button phone_listview_btn_back = (Button) findViewById(R.id.btn_back);
    	
    	phone_listview_btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
            	finish();
            }
        });
	}
	
	//-------------------
	public class MyListAdapter extends ArrayAdapter<JSONObject>
	//-------------------
	{
		//-------------------
		public MyListAdapter()
		//-------------------
		{
			super(MainActivity.getInstance(), R.layout.phone_listview_item_view, Phones.phoneDataList);
		}
		
		//-------------------
		@Override public View getView(int position, View convertView, ViewGroup parent)
		//-------------------
		{
			View itemView = convertView;
			
			if (itemView == null)
			{
				itemView = getLayoutInflater().inflate(R.layout.phone_listview_item_view, parent, false);
			}
			
			JSONObject currentPhone = Phones.phoneDataList.get(position);
			
			//--- Text View ---
	        TextView itemTextView = (TextView)itemView.findViewById(R.id.phone_list_view_item_text);
	        itemTextView.setText(currentPhone.getString("name"));
	        
	        return itemView;
		}
	}
}
