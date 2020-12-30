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
public class GOpenCV extends GWidget {
    //===============================================
    // property
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    // constructor
    //===============================================
    public GOpenCV(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        TextView lTextView = new TextView(context);
        lTextView.setText("GOpenCV");
        lTextView.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lTextView);
    }
    //===============================================
}
//===============================================
