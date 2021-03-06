//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
import android.util.*;
import android.view.*;
import java.util.*;
//===============================================
public class GWidget extends LinearLayout {
    //===============================================
    // property
    //===============================================
    protected List<GWidget> m_itemMap = new ArrayList<GWidget>();
    //===============================================
    // constructor
    //===============================================
    public GWidget(Context context) {
        super(context);
    }
    //===============================================
    public GWidget(Context context, AttributeSet attrs, int defStyleAtt) {
        super(context, attrs, defStyleAtt);
    }
    //===============================================
    public static GWidget Create(String key, Context context) {
        // widget
        if(key.equals("widget")) {return new GWidget(context);}
        if(key.equals("listbox")) {return new GListBox(context);}
        if(key.equals("addressbar")) {return new GAddressBar(context);}
        if(key.equals("addresskey")) {return new GAddressKey(context);}
        if(key.equals("stackwidget")) {return new GStackWidget(context);}
        if(key.equals("titlebar")) {return new GTitleBar(context);}
        if(key.equals("lineedit")) {return new GLineEdit(context);}
        // page
        if(key.equals("window")) {return new GWindow(context);}
        if(key.equals("home")) {return new GHome(context);}
        if(key.equals("login")) {return new GLogin(context);}
        if(key.equals("sqlite")) {return new GSQLiteUi(context);}
        if(key.equals("opencv")) {return new GOpenCVUi(context);}
        if(key.equals("debug")) {return new GDebug(context);}
        // default
        return new GWidget(context); 
    }
    //===============================================
    // observer
    //===============================================
    public void addOnItemClick(GWidget obj) {
        m_itemMap.add(obj);
    }
    //===============================================
    public void emitOnItemClick() {
        for(GWidget lObj : m_itemMap) {
            lObj.onItemClick();
        }
    }
    //===============================================
    // method
    //===============================================
    public int count() {return 0;}
    //
    public void setContent(String text) {}
    public void setCurrentIndex(int index) {}
    //
    public void addItem(String text, String key) {}
    public void addItem(View v) {}
    public void addItem(String key, View v, String title) {}
    public void addItem(String text, String key, String icon) {}
    public void addItem(String key, View v, String title, int isDefault) {}
    //===============================================
    // callback
    //===============================================
    protected void onItemClick() {}
    //===============================================
}
//===============================================
