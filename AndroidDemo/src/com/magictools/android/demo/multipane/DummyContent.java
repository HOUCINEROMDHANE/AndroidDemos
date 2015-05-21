package com.magictools.android.demo.multipane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.magictools.android.demo.R;
import com.magictools.android.demo.R.drawable;

public class DummyContent
{
	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static {
		// Add 3 sample items.
		addItem(new DummyItem("1", "Red Circle", R.drawable.red_circle));
		addItem(new DummyItem("2", "Orange Circle", R.drawable.orange_circle));
		addItem(new DummyItem("3", "Green Circle", R.drawable.green_circle));
		addItem(new DummyItem("4", "Colorful Circle", R.drawable.rainbow_circle));
	}
	
	//-----------
	private static void addItem(DummyItem item)
	//-----------
	{
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	//-----------
	public static class DummyItem
	//-----------
	{
		public String id;
		public String content;
		public int resourceId;

		//-----------
		public DummyItem(String id, String content, int resourceId)
		//-----------
		{
			this.id = id;
			this.content = content;
			this.resourceId = resourceId;
		}

		//-----------
		@Override public String toString()
		//-----------
		{
			return content;
		}
	}
}
