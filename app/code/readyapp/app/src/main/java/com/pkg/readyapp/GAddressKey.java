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
        lApp.address_key = this;
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        setPadding(10, 0, 10, 0);
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
                lButton.setText(lApp.icon_map.get("chevronright"));
                lButton.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
                lButton.setTransformationMethod(null);
                lButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                lButton.setPadding(10, 0, 10, 0);
                addView(lButton);
            }
            
            String lKey = lMap[i];
            
            Button lButton = new Button(lApp.context);
            lButton.setText(lKey);
            lButton.setOnClickListener(this);
            lButton.setTypeface(GManager.Instance().loadFace(lApp.app_font));
            
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
