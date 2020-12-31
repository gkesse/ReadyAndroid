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
public class GAddressBar extends GWidget implements OnClickListener,
    OnKeyListener {
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    public GAddressBar(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        Button lIcon = new Button(context);
        lIcon.setText(lApp.icon_map.get("home"));
        lIcon.setBackgroundColor(Color.TRANSPARENT);
        lIcon.setOnClickListener(this);
        lIcon.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        lIcon.setTransformationMethod(null);
        lIcon.setPadding(10, 0, 10, 0);
        m_widgetMap.put(lIcon, "icon");
        
        EditText lAddress = new EditText(context);
        lApp.address_bar = lAddress;
        lAddress.setBackgroundColor(Color.TRANSPARENT);
        lAddress.setSingleLine(true);
        lAddress.setOnKeyListener(this);
        lAddress.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        lAddress.setTextColor(Color.parseColor("#808080"));
        m_widgetMap.put(lAddress, "address");
        
        Button lGoTo = new Button(context);
        lGoTo.setText(lApp.icon_map.get("paperplaneo"));
        lGoTo.setBackgroundColor(Color.TRANSPARENT);
        lGoTo.setOnClickListener(this);
        lGoTo.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        lGoTo.setTransformationMethod(null);
        lGoTo.setPadding(10, 0, 10, 0);
        m_widgetMap.put(lGoTo, "goto");

        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lIcon, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lAddress, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        addView(lGoTo, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        setBackground(GManager.Instance().bgColor("#503030", 10));
        setPadding(5, 5, 5, 5);
    }
    //===============================================
    // callback
    //===============================================
    @Override
    public void onClick(View v) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        String lWidgetId = m_widgetMap.get(v);
        if(lWidgetId.equals("goto")) {
            String lAddress = lApp.address_bar.getText().toString();
            GManager.Instance().setPage(lAddress);
        }
        else if(lWidgetId.equals("icon")) {
            GManager.Instance().setPage("home");
        }
    }
    //===============================================
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        GManager.sGApp lApp = GManager.Instance().getData().app;
        if((event.getAction() == KeyEvent.ACTION_DOWN) &&
        (keyCode == KeyEvent.KEYCODE_ENTER)) {
            String lAddress = lApp.address_bar.getText().toString();
            GManager.Instance().setPage(lAddress);
            return true;
        }
        return false;
    }    
    //===============================================
}
//===============================================
