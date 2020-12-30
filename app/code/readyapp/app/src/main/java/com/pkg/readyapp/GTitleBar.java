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
import android.util.*;
import java.util.*;
//===============================================
public class GTitleBar extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GTitleBar(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        TextView lLogo = new TextView(context);
        lLogo.setText(lApp.icon_map.get("globe"));
        lLogo.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        
        TextView lAppName = new TextView(context);
        lAppName.setText(lApp.app_name);
        lAppName.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lAppName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40);
        
        TextView lTitle = new TextView(context);
        lApp.title = lTitle;
        lTitle.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lTitle.setGravity(Gravity.CENTER);

        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lLogo, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)); 
        addView(GAndroid.Instance().spaceH(5), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lAppName, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)); 
        addView(GAndroid.Instance().spaceH(30), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lTitle, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1)); 
    }
    //===============================================
}
//===============================================
