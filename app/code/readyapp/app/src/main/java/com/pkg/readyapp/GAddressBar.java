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
        lIcon.setBackground(GAndroid.Instance().bgColor(lApp.button_bg, 0, 0, ""));
        lIcon.setOnClickListener(this);
        lIcon.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        lIcon.setTransformationMethod(null);
        lIcon.setPadding(lApp.button_padding_lr, lApp.button_padding_tb, lApp.button_padding_lr, lApp.button_padding_tb);
        m_widgetMap.put(lIcon, "icon");
        
        EditText lAddress = new EditText(context);
        lApp.address_bar = lAddress;
        lAddress.setSingleLine(true);
        lAddress.setOnKeyListener(this);
        lAddress.setTypeface(GManager.Instance().loadFace(lApp.app_font));
        m_widgetMap.put(lAddress, "address");
        
        GradientDrawable lGoToBg = new GradientDrawable();
        lGoToBg.setColor(Color.parseColor(lApp.button_bg));
        lGoToBg.setCornerRadius(lApp.button_border_radius);
        lGoToBg.setStroke(lApp.button_border_width, Color.parseColor(lApp.button_border));

        Button lGoTo = new Button(context);
        lGoTo.setText(lApp.icon_map.get("paperplaneo"));
        lGoTo.setBackground(lGoToBg);
        lGoTo.setOnClickListener(this);
        lGoTo.setTypeface(GManager.Instance().loadFace(lApp.icon_font));
        lGoTo.setTransformationMethod(null);
        lGoTo.setPadding(lApp.button_padding_lr, lApp.button_padding_tb, lApp.button_padding_lr, lApp.button_padding_tb);
        m_widgetMap.put(lGoTo, "goto");
        
        GradientDrawable lBgColor = new GradientDrawable();
        lBgColor.setColor(Color.parseColor(lApp.button_bg));
        lBgColor.setCornerRadius(lApp.button_border_radius);
        lBgColor.setStroke(lApp.button_border_width, Color.parseColor(lApp.button_border));

        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        setPadding(5, 5, 5, 5);
        addView(lIcon, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lAddress, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        addView(lGoTo, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        setBackground(lBgColor);
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
