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
import android.text.method.*; 
import android.util.*;
import java.util.*;
//===============================================
public class GLogin extends GWidget {
    //===============================================
    // constructor
    //===============================================
    public GLogin(Context context) {
        super(context);
        GManager.sGApp lApp = GManager.Instance().getData().app;
        
        GWidget lUsername = GWidget.Create("lineedit", context);
        lUsername.setContent("Nom d'utilisateur");
        
        GWidget lPassword = GWidget.Create("lineedit", context);
        lPassword.setContent("Mot de passe");
        
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        addView(lUsername);
        addView(GManager.Instance().spaceV(20));
        addView(lPassword);
    }
    //===============================================
}
//===============================================
