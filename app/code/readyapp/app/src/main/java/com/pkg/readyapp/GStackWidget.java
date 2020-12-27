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
public class GStackWidget extends GWidget {
    //===============================================
    // property
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    // constructor
    //===============================================
    public GStackWidget(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
    }
    //===============================================
    // method
    //===============================================
    public void addItem(View v) {
        addView(v);
    }
    //===============================================
}
//===============================================
