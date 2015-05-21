package com.magictools.android.demo;

import com.magictools.android.demo.googlemaps.GoogleMapsActivity;
import com.magictools.android.demo.imageslider.SampleCirclesDefault;
import com.magictools.android.demo.imageslider.SimpleSlider;
import com.magictools.android.demo.multipane.CircleListActivity;
import com.magictools.android.demo.opengl.MyGLActivity;
import com.magictools.android.demo.phonecatalog.PhoneListViewActivity;
import com.magictools.android.demo.phonecatalog.Phones;
import com.magictools.android.demo.takepicture.TakePictureActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity
{
	public static MainActivity instance = null;

	String[] demoList = {
			"Take Picture Demo", 
			"Google Maps Demo", 
			"Phone Catalog Demo",
			"Multi Pane Demo",
			"OpenGL Demo",
			"Image Slider Demo",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
			" ",
		};

 	//-------------------------------------------
	public static MainActivity getInstance()
	//-------------------------------------------
	{
		return instance;
	}
	
	//-------------------
    @Override protected void onCreate(Bundle savedInstanceState)
	//-------------------
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        instance = this;
        
        Phones.loadPhonesData();
        populateListView();
        registerClickCallback();
    }
    
	//-------------------
	void populateListView()
	//-------------------
	{
		ArrayAdapter<String> adapter = new MyListAdapter();
		ListView listView = (ListView) MainActivity.getInstance().findViewById(R.id.ListViewMain);
		listView.setAdapter(adapter);
	}
	
	//-------------------
    void registerClickCallback()
	//-------------------
    {
    	ListView listView = (ListView) MainActivity.getInstance().findViewById(R.id.ListViewMain);
    	
    	listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				switch (position)
				{
					case 0:
					{
	    				Intent i = new Intent(MainActivity.getInstance(), TakePictureActivity.class);
	    				MainActivity.getInstance().startActivity(i);
						
						break;
					}
					
					case 1:
					{
	    				Intent i = new Intent(MainActivity.getInstance(), GoogleMapsActivity.class);
	    				MainActivity.getInstance().startActivity(i);
						
						break;
					}
					
					case 2:
					{
	    				Intent i = new Intent(MainActivity.getInstance(), PhoneListViewActivity.class);
	    				MainActivity.getInstance().startActivity(i);
						
						break;
					}
					
					case 3:
					{
	    				Intent i = new Intent(MainActivity.getInstance(), CircleListActivity.class);
	    				MainActivity.getInstance().startActivity(i);
						
						break;
					}
					
					case 4:
					{
	    				Intent i = new Intent(MainActivity.getInstance(), MyGLActivity.class);
	    				MainActivity.getInstance().startActivity(i);
						
						break;
					}
					
					case 5:
					{
	    				Intent i = new Intent(MainActivity.getInstance(), SimpleSlider.class);
	    				MainActivity.getInstance().startActivity(i);
						
						break;
					}
				}
			}
    	});
    	
    	Button btn_exit = (Button) MainActivity.getInstance().findViewById(R.id.main_screen_btn_exit);
    	
    	btn_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
            	MainActivity.getInstance().finish();
            }
        });
	}
	
	//-------------------
	public class MyListAdapter extends ArrayAdapter<String>
	//-------------------
	{
		//-------------------
		public MyListAdapter()
		//-------------------
		{
			super(MainActivity.getInstance(), R.layout.main_screen_item_view, demoList);
		}
		
		//-------------------
		@Override public View getView(int position, View convertView, ViewGroup parent)
		//-------------------
		{
			View itemView = convertView;
			
			if (itemView == null)
			{
				itemView = MainActivity.getInstance().getLayoutInflater().inflate(R.layout.main_screen_item_view, parent, false);
			}
			
			String currentDemo = demoList[position];
			
			//--- Text View ---
	        TextView itemTextView = (TextView)itemView.findViewById(R.id.main_screen_item_text);
	        itemTextView.setText(currentDemo);
	        
	        return itemView;
		}
	}
//	//-------------------
//	@Override public boolean onCreateOptionsMenu(Menu menu)
//	//-------------------
//	{
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//	
//	//-------------------
//    @Override public boolean onOptionsItemSelected(MenuItem item)
//	//-------------------
//    {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        
//        if (id == R.id.action_settings)
//        {
//            return true;
//        }
//        
//        return super.onOptionsItemSelected(item);
//    }
}
