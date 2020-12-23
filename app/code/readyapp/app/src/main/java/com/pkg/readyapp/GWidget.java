//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
//===============================================
public class GWidget extends LinearLayout {
    //===============================================
    public GWidget(Context context) {
        super(context);
    }
    //===============================================
    public static GWidget Create(String key, Context context) {
        if(key == "widget") {return new GWidget(context);}
        if(key == "listbox") {return new GListBox(context);}
        return new GWidget(context); 
    }
    //===============================================
}
//===============================================
