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
public class GHome extends GWidget {
    //===============================================
    // property
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    // constructor
    //===============================================
    public GHome(Context context) {
        super(context);
        
        GWidget lListBox = GWidget.Create("listbox", context);
        lListBox.addOnItemClick(this);
        lListBox.addItem("SQLite", "home/sqlite");
        lListBox.addItem("OpenCV", "home/opencv");
        lListBox.addItem("Layout", "home/layout");
        
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lListBox);
        setBackground(GAndroid.Instance().bgColor("", 10, 1, "#503030"));
    }
    //===============================================
    // callback
    //===============================================
    @Override
    public void onItemClick() {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        GManager.Instance().setPage(lApp.widget_id);
    }
    //===============================================
}
//===============================================
