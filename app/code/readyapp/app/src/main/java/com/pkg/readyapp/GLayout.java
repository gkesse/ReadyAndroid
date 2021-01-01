//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.view.*;
import android.view.View.*;
import java.util.*;
//===============================================
public class GLayout extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GLayout(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;

        LayoutInflater lLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        View lView = lLayoutInflater.inflate(R.layout.activity_main, null);

        TextView lTextView = (TextView)lView.findViewById(R.id.hello_world);
        lTextView.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lView);
    }
    //===============================================
}
//===============================================
