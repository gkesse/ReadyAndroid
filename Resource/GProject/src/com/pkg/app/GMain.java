//===============================================
package com.pkg.app;
//===============================================
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
//===============================================
public class GMain extends Activity {
    //===============================================
    private TextView m_textView = null;
    //===============================================
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        m_textView = new TextView(this);
        m_textView.setText(R.string.hello_world);
        
        setContentView(m_textView);
    }
    //===============================================
}
//===============================================
