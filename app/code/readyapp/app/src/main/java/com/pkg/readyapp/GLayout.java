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
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        LayoutInflater lLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        View lMainActivity = lLayoutInflater.inflate(R.layout.activity_main, null);
        addView(lMainActivity);
    }
    //===============================================
}
//===============================================
