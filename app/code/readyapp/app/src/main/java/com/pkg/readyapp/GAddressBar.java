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
public class GAddressBar extends GWidget implements OnClickListener {
    //===============================================
    private HashMap<View, String> m_widgetMap = new HashMap<View, String>();
    //===============================================
    public GAddressBar(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        GradientDrawable lIconBg = new GradientDrawable();
        lIconBg.setColor(Color.parseColor(lApp.button_bg));
        lIconBg.setCornerRadius(lApp.button_border_radius);
        lIconBg.setStroke(lApp.button_border_width, Color.parseColor(lApp.button_border));
        
        Button lIcon = new Button(context);
        lIcon.setText("icon");
        lIcon.setBackground(lIconBg);
        lIcon.setOnClickListener(this);
        m_widgetMap[lIcon] = "icon";
        
        EditText lAddress = new EditText(context);
        lAddress.setSingleLine(true);
        
        GradientDrawable lGoToBg = new GradientDrawable();
        lGoToBg.setColor(Color.parseColor(lApp.button_bg));
        lGoToBg.setCornerRadius(lApp.button_border_radius);
        lGoToBg.setStroke(lApp.button_border_width, Color.parseColor(lApp.button_border));

        Button lGoTo = new Button(context);
        lGoTo.setText("goto");
        lGoTo.setBackground(lGoToBg);
        lGoTo.setOnClickListener(this);
        m_widgetMap[lGoTo] = "goto";
        
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lIcon, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lAddress, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        addView(lGoTo, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
    //===============================================
    @Override
    public void onClick(View v) {
        String lWidgetId = m_widgetMap[v];
        GManager.Instance().showMessage(lWidgetId);
    }
    //===============================================
}
//===============================================
