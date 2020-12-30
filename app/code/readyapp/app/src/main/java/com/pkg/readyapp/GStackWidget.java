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
    private HashMap<Integer, View> m_widgetMap = new HashMap<Integer, View>();
    private int m_count = 0;
    private int m_currentIndex = 0;
    //===============================================
    // constructor
    //===============================================
    public GStackWidget(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        setBackground(GAndroid.Instance().bgColor("", 10, 2, "#503030"));
        setPadding(20, 10, 20, 10);
    }
    //===============================================
    // method
    //===============================================
    public void addItem(View v) {
        addView(v);
        m_widgetMap.put(m_count, v);
        if(m_count != m_currentIndex) {v.setVisibility(View.GONE);}
        m_count++;
    }
    //===============================================
    public void setCurrentIndex(int index) {
        View lView = m_widgetMap.get(m_currentIndex);
        lView.setVisibility(View.GONE);
        m_currentIndex = index;
        lView = m_widgetMap.get(m_currentIndex);
        lView.setVisibility(View.VISIBLE);
    }
    //===============================================
    public int count() {
        return m_count;
    }
    //===============================================
}
//===============================================
