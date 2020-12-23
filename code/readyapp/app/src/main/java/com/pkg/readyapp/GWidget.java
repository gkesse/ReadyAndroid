//===============================================
package com.pkg.readyapp;
//===============================================
import android.view.*;
import android.content.*;
import android.widget.*;
import android.widget.LinearLayout.*;
//===============================================
public class GWidget extends ViewGroup {
    //===============================================
    public GWidget(Context context) {
        super(context);
        LinearLayout lMainLayout = new LinearLayout(context);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        
        Button lMenuB = new Button(context);
        lMenuB.setText("lMenuN");
        lMenuB.setAllCaps(false);
        lMenuB.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lMainLayout.addView(lMenuB);
        addView(lMainLayout);
    }
    //===============================================
    public static GWidget Create(String key, Context context) {
        if(key == "default") return new GWidget(context);
        return new GWidget(context);
    }
    //===============================================
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
    }
    //===============================================
}
//===============================================
