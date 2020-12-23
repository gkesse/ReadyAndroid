//===============================================
package com.pkg.readyapp;
//===============================================
import android.os.*;
import android.app.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.LinearLayout.*;
import android.content.*;
import android.graphics.*;
import java.util.*;
//===============================================
public class GCustomView extends View {
    //===============================================
    private Paint m_paint;
    private int m_bgColor;
    private String m_text;
    //===============================================
    public GCustomView(Context context) {
        super(context);
        m_paint = new Paint();
        m_paint.setColor(Color.parseColor("#ffffff"));
        m_paint.setTextSize(30);
        m_bgColor = Color.parseColor("#202020");
        m_text = "Je suis une vue personnalisée";
    }
    //===============================================
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(m_bgColor);
        canvas.drawText(m_text, 50, 50, m_paint);
    }
    //===============================================
    public void setBgColor(String color) {
        m_bgColor = Color.parseColor(color);
        invalidate();
    }
    //===============================================
    public void setText(String text) {
        m_text = text;
        invalidate();
    }
    //===============================================
}
//===============================================
