//===============================================
package com.pkg.readyapp;
//===============================================
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.content.*;
import android.net.*;
//===============================================
public class GMainActivity extends Activity {
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {      
        super.onCreate(savedInstanceState);

        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        
        TextView lTextView = new TextView(this);
        lTextView.setText("Je suis l'activié principale");
        
        GFragment lFragment = new GFragment();
        LinearLayout lFragLayout = new LinearLayout(this);
        lFragLayout.setOrientation(LinearLayout.VERTICAL);
        lFragLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lFragLayout.setId(View.generateViewId());
        getFragmentManager().beginTransaction().add(lFragLayout.getId(), lFragment).commit();
                
        lMainLayout.addView(lTextView);
        lMainLayout.addView(lFragLayout);

        setContentView(lMainLayout);
    }
    //===============================================
}
//===============================================
