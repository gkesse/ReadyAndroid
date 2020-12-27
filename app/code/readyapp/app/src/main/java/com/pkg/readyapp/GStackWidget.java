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
    private HashMap<View, Integer> m_widgetMap = new HashMap<View, Integer>();
    private int m_count = 0;
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
        m_widgetMap.put(v, m_count);
        if(m_count != 0) {v.setVisibility(View.INVISIBLE); }
        m_count++;
    }
    //===============================================
}
//===============================================
