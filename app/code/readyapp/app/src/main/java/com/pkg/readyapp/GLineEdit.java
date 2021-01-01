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
import android.text.method.*; 
import android.util.*;
import java.util.*;
//===============================================
public class GLineEdit extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GLineEdit(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
    }
    //===============================================
    // method
    //===============================================
    public void setContent(String label) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        TextView lLabel = new TextView(lApp.context);
        lLabel.setText(label);
        lLabel.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lLabel.setBackground(GManager.Instance().bgColor("#503030", 10, 0, 0, 10));
        lLabel.setPadding(20, 5, 20, 5);
        lLabel.setMinimumWidth(50);

        EditText lEdit = new EditText(lApp.context);
        lEdit.setBackgroundColor(Color.TRANSPARENT);
        lEdit.setSingleLine(true);
        //lAddress.setOnKeyListener(this);
        lEdit.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lEdit.setTextColor(Color.parseColor("#808080"));

        addView(lLabel, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));        
        addView(GManager.Instance().spaceV(20), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lEdit, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        setBackground(GManager.Instance().bgColor("", 10, 2, "#503030"));
    }
    //===============================================
}
//===============================================
