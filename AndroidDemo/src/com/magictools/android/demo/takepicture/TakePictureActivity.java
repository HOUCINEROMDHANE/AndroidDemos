package com.magictools.android.demo.takepicture;

import com.magictools.android.demo.R;
import com.magictools.android.demo.R.id;
import com.magictools.android.demo.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TakePictureActivity extends Activity
{
    private static final int CAMERA_REQUEST = 1888; 
    private ImageView imageView;
    
	//-------------------
	@Override public void onCreate(Bundle savedInstanceState)
	//-------------------
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.take_picture);
		
		populateView();
		registerClickCallback();
	}
	
	//-------------------
    void registerClickCallback()
	//-------------------
    {
        this.imageView = (ImageView)this.findViewById(R.id.take_picture_img);
        
        Button photoButton = (Button) this.findViewById(R.id.take_picture_btn);
        
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
            }
        });
        
    	Button btn_back = (Button) findViewById(R.id.btn_back);
    	
    	btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
            	finish();
            }
        });
	}
    
	//-------------------
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
	//-------------------
    {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {  
            Bitmap photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    }
    
	//-------------------
	void populateView()
	//-------------------
	{
		
	}
}
