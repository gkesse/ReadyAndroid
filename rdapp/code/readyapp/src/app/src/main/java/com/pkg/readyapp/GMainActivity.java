//===============================================
package com.pkg.readyapp;
//===============================================
import androidx.appcompat.app.*;
import android.os.*;
import android.widget.*;
import android.widget.LinearLayout.*;
//===============================================
public class GMainActivity extends AppCompatActivity {
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        lApp.context = this;

        GManager.Instance().loadData();
        
        GWidget lTitleBar = GWidget.Create("titlebar", this);
        GWidget lAddressBar = GWidget.Create("addressbar", this);
        GWidget lAddressKey = GWidget.Create("addresskey", this);
        GWidget lWindow = GWidget.Create("window", this);
        
        lWindow.addItem("home", GWidget.Create("home", this), "Accueil", 1);
        lWindow.addItem("home/login", GWidget.Create("login", this), "Connexion", 1);
        lWindow.addItem("home/sqlite", GWidget.Create("sqlite", this), "SQLite");
        lWindow.addItem("home/opencv", GWidget.Create("opencv", this), "OpenCV");
        lWindow.addItem("home/debug", GWidget.Create("debug", this), "Debug");
        
        GSQLite.Instance();

        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);       
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        lMainLayout.addView(lTitleBar); lMainLayout.addView(GManager.Instance().spaceV(20));
        lMainLayout.addView(lAddressBar); lMainLayout.addView(GManager.Instance().spaceV(20));
        lMainLayout.addView(lAddressKey); lMainLayout.addView(GManager.Instance().spaceV(20));
        lMainLayout.addView(lWindow); lMainLayout.addView(GManager.Instance().spaceV(20));
        lMainLayout.setPadding(20, 10, 20, 10);

        getSupportActionBar().hide();
        setContentView(lMainLayout);
    }
    //===============================================
}
//===============================================
