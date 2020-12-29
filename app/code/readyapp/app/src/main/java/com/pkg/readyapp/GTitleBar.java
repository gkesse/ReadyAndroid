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
public class GTitleBar extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GTitleBar(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        
        TextView lTextView = new TextView(context);
        lApp.title = lTextView;
        lTextView.setTypeface(GManager.Instance().loadFont(lApp.font_app));
        
        addView(lTextView);
    }
    //===============================================
}
//===============================================
