//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
import android.widget.*;
import android.widget.LinearLayout.*;
//===============================================
public class GAddressKey extends GWidget {
    //===============================================
    public GAddressKey(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        TextView lTextView = new TextView(context);
        lTextView.setText("GAddressKey");
        addView(lTextView);
    }
    //===============================================
}
//===============================================
