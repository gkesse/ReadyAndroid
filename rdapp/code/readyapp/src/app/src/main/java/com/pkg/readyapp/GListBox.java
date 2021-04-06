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
import android.util.*;
import java.util.*;
//===============================================
public class GListBox extends GWidget implements OnClickListener {
    //===============================================
    // property
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    // constructor
    //===============================================
    public GListBox(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        setBackgroundColor(Color.TRANSPARENT);
    }
    //===============================================
    // method
    //===============================================
    public void addItem(String text, String key, String icon) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        Button lIcon = new Button(lApp.context);
        lIcon.setText(lApp.icon_map.get(icon));
        lIcon.setOnClickListener(this);
        lIcon.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        lIcon.setBackgroundColor(Color.TRANSPARENT);
        lIcon.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);
        lIcon.setMinimumWidth(45);
        m_widgetMap.put(lIcon, key);
        
        Button lButton = new Button(lApp.context);
        lButton.setText(text);
        lButton.setOnClickListener(this);
        lButton.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lButton.setBackgroundColor(Color.TRANSPARENT);
        m_widgetMap.put(lButton, key);
        
        LinearLayout lItemLayout = new LinearLayout(lApp.context);
        lItemLayout.setOrientation(LinearLayout.HORIZONTAL);       
        lItemLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        lItemLayout.setBackgroundColor(Color.TRANSPARENT);
        lItemLayout.addView(lIcon, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lItemLayout.addView(GManager.Instance().spaceH(2), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lItemLayout.addView(lButton, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        
        addView(lItemLayout);
    }
    //===============================================
    public void addItem(String text, String key) {
        addItem(text, key, "");
    }
    //===============================================
    // callback
    //===============================================
    @Override
    public void onClick(View v) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        String lWidgetId = m_widgetMap.get(v);
        lApp.widget_id = lWidgetId;
        emitOnItemClick();
    }
    //===============================================
}
//===============================================
