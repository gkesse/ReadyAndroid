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
    }
    //===============================================
    // method
    //===============================================
    public void addItem(String text, String key) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        Button lButton = new Button(lApp.context);
        lButton.setText(text);
        lButton.setOnClickListener(this);
        lButton.setTypeface(GManager.Instance().loadFont("fonts/allan_regular.ttf"));

        m_widgetMap.put(lButton, key);
        
        addView(lButton);
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
