package com.magictools.android.demo.utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;

import com.magictools.android.demo.MainActivity;

import android.content.res.AssetManager;

public class Utils
{
	//-------------------
	public static JSONObject loadJSONObjectFromAssets(String fileName)
	//-------------------
	{
        String jsonString = null;
        
        try
        {
            InputStream is = MainActivity.getInstance().getAssets().open(fileName);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            jsonString = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        
        JSONObject jsonObject = new JSONObject(jsonString);
        
        return jsonObject;
    }
	
	//-------------------
	public static JSONArray loadJSONArrayFromAssets(String fileName)
	//-------------------
	{
        String jsonString = null;
        
        try
        {
            InputStream is = MainActivity.getInstance().getAssets().open(fileName);
            
            int size = is.available();
            
            byte[] buffer = new byte[size];
            
            is.read(buffer);
            
            is.close();
            
            jsonString = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        
        JSONArray jsonObject = new JSONArray(jsonString);
        
        return jsonObject;
    }
}
