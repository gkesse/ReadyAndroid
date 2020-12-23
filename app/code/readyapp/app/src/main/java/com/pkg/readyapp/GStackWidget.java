//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
import android.widget.*;
import android.widget.LinearLayout.*;
//===============================================
public class GStackWidget extends GWidget {
    //===============================================
    public GStackWidget(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);       
        setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        TextView lTextView = new TextView(context);
        lTextView.setText("GStackWidget");
        addView(lTextView);
    }
    //===============================================
}
//===============================================
