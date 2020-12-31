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
public class GDebug extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GDebug(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;

        TextView lDebug = new TextView(context);
        lApp.debug = lDebug;
        lDebug.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lDebug);
    }
    //===============================================
}
//===============================================
