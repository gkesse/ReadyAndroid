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
// manager
//===============================================
public class GAndroid {
    //===============================================
    private static GAndroid m_intance = null;
    //===============================================
    private GAndroid() {

    }
    //===============================================
    public static synchronized GAndroid Instance() {           
        if(m_intance == null) {   
            m_intance = new GAndroid(); 
        }
        return m_intance;
    }
    //===============================================
    // space
    //===============================================
    public View spaceV(int size) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        Space lSpace = new Space(lApp.context);
        lSpace.setMinimumHeight(size);
        return lSpace;
    }
    //===============================================
    public View spaceH(int size) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        Space lSpace = new Space(lApp.context);
        lSpace.setMinimumWidth(size);
        return lSpace;
    }
    //===============================================
    // bgcolor
    //===============================================
    public GradientDrawable bgColor(String bgColor, int borderRadius, int borderWidth, String borderColor) {
        GradientDrawable lBgColor = new GradientDrawable();
        if(bgColor.equals("")) {lBgColor.setColor(Color.parseColor(bgColor));}
        if(borderRadius != 0) {lBgColor.setCornerRadius(borderRadius);}
        if(borderWidth != 0) {lBgColor.setStroke(borderWidth, Color.parseColor(borderColor));}
        return lBgColor;
    }
    //===============================================
    public GradientDrawable bgColor(String bgColor, int borderRadius) {
        return bgColor(bgColor, borderRadius, 0, "");
    }
    //===============================================
    public GradientDrawable bgColor(String bgColor) {
        return bgColor(bgColor, 0, 0, "");
    }
    //===============================================
}
//===============================================
