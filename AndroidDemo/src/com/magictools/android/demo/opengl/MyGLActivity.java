package com.magictools.android.demo.opengl;

import com.magictools.android.demo.R;
import com.magictools.android.demo.R.id;
import com.magictools.android.demo.R.layout;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyGLActivity extends Activity
{
    public static GLSurfaceView mGLView;

	//---------------
    @Override  public void onCreate(Bundle savedInstanceState)
	//---------------
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opengl_view);
        mGLView = (MyGLSurfaceView) findViewById(R.id.glSurfaceViewID);
        
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
            	MyGLRenderer.mExit = true;
            	
            	finish();
            }
        });
	}
    
	//---------------
    @Override protected void onPause()
	//---------------
    {
        super.onPause();
        mGLView = (MyGLSurfaceView)findViewById(R.id.glSurfaceViewID);
        mGLView.onPause();
    }

	//---------------
   @Override protected void onResume()
	//---------------
   {
        super.onResume();
        mGLView = (MyGLSurfaceView)findViewById(R.id.glSurfaceViewID);
        mGLView.onResume();
    }
}
