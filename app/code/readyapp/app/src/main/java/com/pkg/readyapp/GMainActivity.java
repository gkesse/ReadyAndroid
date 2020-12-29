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
        GManager.sGApp lApp = GManager.Instance().getData().app;
        lApp.context = this;
                        
        GWidget lTitleBar = GWidget.Create("titlebar", this);
        GWidget lAddressBar = GWidget.Create("addressbar", this);
        GWidget lAddressKey = GWidget.Create("addresskey", this);
        GWidget lWindow = GWidget.Create("window", this);
        
        lWindow.addItem("home", GWidget.Create("home", this), "Accueil", 1);
        lWindow.addItem("home/sqlite", GWidget.Create("sqlite", this), "SQLite");
        lWindow.addItem("home/opencv", GWidget.Create("opencv", this), "OpenCV");
        lWindow.addItem("home/layout", GWidget.Create("layout", this), "Layout");
        
        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);       
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lMainLayout.setPadding(10, 10, 10, 10);
        lMainLayout.addView(lTitleBar);
        lMainLayout.addView(lAddressBar);
        lMainLayout.addView(lAddressKey);
        lMainLayout.addView(lWindow);
        
        setContentView(lMainLayout);
    }
    //===============================================
}
//===============================================
