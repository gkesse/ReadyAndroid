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
    public View space(int size) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        Space lSpace = new Space(lApp.context);
        lSpace.setMinimumHeight(size);
        return lSpace;
    }
    //===============================================
}
//===============================================
