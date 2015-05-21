package com.magictools.android.demo.phonecatalog;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.magictools.android.demo.utils.Utils;

public class Phones
{
	public static List<JSONObject> phoneDataList = new ArrayList<JSONObject>();

	//-------------------
	Phones()
	//-------------------
	{
		
	}
	
	//-------------------
	public static void loadPhonesData()
	//-------------------
	{
		JSONArray phoneData = Utils.loadJSONArrayFromAssets("phones/phones.json");
		
		for (int i=0; i<phoneData.length(); i++)
		{
			phoneDataList.add(((JSONObject)phoneData.get(i)));
		}
	}
}
