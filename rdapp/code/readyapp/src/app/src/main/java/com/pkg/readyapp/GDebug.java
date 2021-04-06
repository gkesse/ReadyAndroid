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
import android.text.method.*; 
import android.util.*;
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
        lDebug.setTypeface(GManager.Instance().loadFace(lApp.debug_font));
        lDebug.setMovementMethod(new ScrollingMovementMethod());
        lDebug.setHorizontallyScrolling(true);
        lDebug.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
        
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lDebug);
    }
    //===============================================
}
//===============================================
