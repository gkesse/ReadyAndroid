//===============================================
package com.pkg.readyapp;
//===============================================
import android.app.*;
//===============================================
public class GActivity extends Activity {
    //===============================================
    public static GActivity Create(String key) {
        if(key == "default") return new GActivity();
        return new GActivity();
    }
    //===============================================
}
//===============================================
