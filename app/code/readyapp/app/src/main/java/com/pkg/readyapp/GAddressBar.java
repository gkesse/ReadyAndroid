//===============================================
package com.pkg.readyapp;
//===============================================
import android.widget.*;
import android.content.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.graphics.*;
//===============================================
public class GAddressBar extends GWidget {
    //===============================================
    public GAddressBar(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);       
        setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
        
        Button lIcon = new Button(context);
        lIcon.setText("icon");
        lIcon.setBackgroundColor(Color.parseColor("#503030"));
        
        EditText lAddress = new EditText(context);
        lAddress.setSingleLine(true);
        
        Button lGoTo = new Button(context);
        lGoTo.setText("goto");
        lGoTo.setBackgroundColor(Color.parseColor("#503030"));
        
        addView(lIcon, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(lAddress, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        addView(lGoTo, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }
    //===============================================
}
//===============================================
