//===============================================
package com.pkg.readyapp;
//===============================================
import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.LinearLayout.*;
//===============================================
public class GMainActivity extends Activity {
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout lMainLayout = new LinearLayout(this);
        
        lMainLayout.setOrientation(LinearLayout.VERTICAL);       
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        GWidget lAddressBar = GWidget.Create("addressbar", this);
        GWidget lAddressKey = GWidget.Create("addresskey", this);
        GWidget lStackWidget = GWidget.Create("stackwidget", this);
        
        lMainLayout.addView(lAddressBar);
        lMainLayout.addView(lAddressKey);
        lMainLayout.addView(lStackWidget);
        
        setContentView(lMainLayout);
    }
    //===============================================
}
//===============================================
