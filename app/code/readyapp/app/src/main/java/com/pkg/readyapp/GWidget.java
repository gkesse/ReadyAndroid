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
    public static GWidget Create(String key, Context context) {
        // widget
        if(key.equals("widget")) {return new GWidget(context);}
        if(key.equals("listbox")) {return new GListBox(context);}
        if(key.equals("addressbar")) {return new GAddressBar(context);}
        if(key.equals("addresskey")) {return new GAddressKey(context);}
        if(key.equals("stackwidget")) {return new GStackWidget(context);}
        // page
        if(key.equals("home")) {return new GHome(context);}
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
    public void setContent(String text) {}
    public void addItem(String text, String key) {}
    public void addItem(View v) {}
    //===============================================
    // callback
    //===============================================
    protected void onItemClick() {}
    //===============================================
}
//===============================================
