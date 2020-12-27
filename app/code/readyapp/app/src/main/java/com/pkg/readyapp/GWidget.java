//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
import android.util.*;
//===============================================
public class GWidget extends LinearLayout {
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
    // method
    //===============================================
    public void setContent(String text) {}
    public void setOnItemClcik(OnItemClick obj) {}
    public void addItem(String text, String key) {}
    //===============================================
    // callback
    //===============================================
    interface OnItemClick {
        void onItemClcik();
    }
    //===============================================
    //===============================================
}
//===============================================
