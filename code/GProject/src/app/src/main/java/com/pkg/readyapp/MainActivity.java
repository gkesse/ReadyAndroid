//===============================================
package com.pkg.readyapp;
//===============================================
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
//===============================================
public class MainActivity extends Activity {
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView lTextView = new TextView(this);
        lTextView.setText("Bonjour tout le monde");
        setContentView(lTextView);
    }
    //===============================================
}
//===============================================
