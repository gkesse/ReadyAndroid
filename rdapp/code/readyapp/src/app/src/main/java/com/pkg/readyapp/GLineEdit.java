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
import android.text.*;
import java.util.*;
//===============================================
public class GLineEdit extends GWidget {
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
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
        
        Button lIcon = new Button(lApp.context);
        lIcon.setText(lApp.icon_map.get("user"));
        lIcon.setBackgroundColor(Color.TRANSPARENT);
        //lIcon.setOnClickListener(this);
        lIcon.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        lIcon.setTransformationMethod(null);
        lIcon.setBackgroundColor(Color.TRANSPARENT);
        m_widgetMap.put(lIcon, "icon");

        TextView lLabel = new TextView(lApp.context);
        lLabel.setText(label);
        lLabel.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lLabel.setBackgroundColor(Color.TRANSPARENT);
        lLabel.setMinimumWidth(300);
        m_widgetMap.put(lLabel, "label");

        LinearLayout lLabelLayout = new LinearLayout(lApp.context);
        lLabelLayout.setOrientation(LinearLayout.HORIZONTAL);       
        lLabelLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        lLabelLayout.addView(lIcon);
        lLabelLayout.addView(GManager.Instance().spaceH(20));
        lLabelLayout.addView(lLabel);
        lLabelLayout.setBackground(GManager.Instance().bgColor("#503030", 10, 0, 0, 10));
        lLabelLayout.setPadding(20, 5, 20, 5);
        
        EditText lEdit = new EditText(lApp.context);
        lEdit.setBackgroundColor(Color.TRANSPARENT);
        lEdit.setSingleLine(true);
        //lAddress.setOnKeyListener(this);
        lEdit.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lEdit.setTextColor(Color.parseColor("#808080"));
        lEdit.setPadding(20, 0, 20, 0);
        lEdit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        m_widgetMap.put(lEdit, "edit");

        addView(lLabelLayout, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));        
        addView(GManager.Instance().spaceV(20), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lEdit, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        setBackground(GManager.Instance().bgColor("", 10, 2, "#503030"));
    }
    //===============================================
}
//===============================================
