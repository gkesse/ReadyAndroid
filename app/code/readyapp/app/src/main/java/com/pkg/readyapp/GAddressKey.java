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
public class GAddressKey extends GWidget implements OnClickListener {
    //===============================================
    // property
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    // constructor
    //===============================================
    public GAddressKey(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        lApp.address_key = this;
    }
    //===============================================
    // method
    //===============================================
    public void setContent(String text) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        removeAllViews();

        String[] lMap = text.split("/");
        String lKeyId = "";

        for(int i = 0; i < lMap.length; i++) {
            if(i != 0) {
                Button lButton = new Button(lApp.context);
                lButton.setText(">");
                addView(lButton);
            }
            
            String lKey = lMap[i];
            
            GradientDrawable lButtonBg = new GradientDrawable();
            lButtonBg.setColor(Color.parseColor(lApp.button_bg));
            lButtonBg.setCornerRadius(lApp.button_border_radius);
            lButtonBg.setStroke(lApp.button_border_width, Color.parseColor(lApp.button_border));
            
            Button lButton = new Button(lApp.context);
            lButton.setText(lKey);
            lButton.setBackground(lButtonBg);
            lButton.setOnClickListener(this);
            
            if(i != 0) lKeyId += "/";
            lKeyId += lKey;
            
            m_widgetMap.put(lButton, lKeyId);
            
            addView(lButton);
        }        
    }
    //===============================================
    // callback
    //===============================================
    @Override
    public void onClick(View v) {
        String lWidgetId = m_widgetMap.get(v);
        GManager.Instance().setPage(lWidgetId);
    }
    //===============================================
}
//===============================================
