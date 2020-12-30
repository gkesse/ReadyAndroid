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
        GWidget lWorkspaceH = GWidget.Create("stackwidget", context);
        lApp.page_map = lWorkspaceH;
        addView(lWorkspaceH);
    }
    //===============================================
    // method
    //===============================================
    public void addItem(String key, View v, String title, int isDefault) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        int lIndex = lApp.page_map.count();
        lApp.page_map.addItem(v);
        lApp.page_id.put(key, lIndex);
        lApp.title_map.put(key, title);
        if(isDefault == 1) {GManager.Instance().setPage(key);}
    }
    //===============================================
    public void addItem(String key, View v, String title) {
        addItem(key, v, title, 0);
    }
    //===============================================
}
//===============================================
