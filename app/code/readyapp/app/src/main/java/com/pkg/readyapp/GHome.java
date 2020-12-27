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
public class GHome extends GWidget implements GWidget.OnItemClcik {
    //===============================================
    // property
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    // constructor
    //===============================================
    public GHome(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        
        GWidget lListBox = GWidget.Create("listbox", this);
        lListBox.addItem("SQLite", "home/sqlite");
        lListBox.addItem("OpenCV", "home/opencv");
        
        addView(lListBox);
    }
    //===============================================
    // method
    //===============================================
    public void addItem(String text, String key) {
        GradientDrawable lButtonBg = new GradientDrawable();
        lButtonBg.setColor(Color.parseColor(lApp.button_bg));
        lButtonBg.setCornerRadius(lApp.button_border_radius);
        lButtonBg.setStroke(lApp.button_border_width, Color.parseColor(lApp.button_border));
        
        Button lButton = new Button(lApp.context);
        lButton.setText(text);
        lButton.setBackground(lButtonBg);
        lButton.setOnClickListener(this);

        m_widgetMap.put(lButton, key);
        
        addView(lButton);
    }
    //===============================================
    // callback
    //===============================================
    @Override
    public void onItemClick() {
        String lWidgetId = m_widgetMap.get(v);
        GManager.Instance().showMessage(lWidgetId);
    }
    //===============================================
}
//===============================================
