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
        
        lMainLayout.addView(GWidget.Create("addressbar", this));
        lMainLayout.addView(GWidget.Create("addresskey", this));
        lMainLayout.addView(GWidget.Create("stackwidget", this));
        
        setContentView(lMainLayout);
    }
    //===============================================
}
//===============================================
