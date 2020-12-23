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
public class GSQLiteUi extends Activity implements OnClickListener {
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {      
        super.onCreate(savedInstanceState);

        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        TextView lTextView = new TextView(this);
        lTextView.setText("Menu principal");
        
        Button lButton = new Button(this);
        lButton.setText("Terminer");
        lButton.setAllCaps(false);
        lButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lButton.setOnClickListener(this);
        
        lMainLayout.addView(lButton);

        setContentView(lMainLayout);
    }
    //===============================================
    @Override
    public void onClick(View v) {
        finish();
    }
    //===============================================
}
//===============================================
