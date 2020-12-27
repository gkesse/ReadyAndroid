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
public class GWindow extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GWindow(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        GWidget lWorkspace = GWidget.Create("stackwidget", context);
        lApp.page_map = lWorkspace;
        addView(lWorkspace);
    }
    //===============================================
    // method
    //===============================================
    public void addItem(String key, View v) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        int lIndex = m_workspace.count();
        lApp.page_map.addItem(v);
        lApp.page_id.put(key, lIndex);
    }
    //===============================================
}
//===============================================
