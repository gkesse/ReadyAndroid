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
import android.graphics.*;
import android.net.*;
//===============================================
public class GMainActivity extends Activity implements OnClickListener {
    //===============================================
    private GCustomView m_customView;
    private String m_state = "red";
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {      
        super.onCreate(savedInstanceState);

        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                                        
        Button lButton = new Button(this);
        lButton.setText("Action");
        lButton.setAllCaps(false);
        lButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        lButton.setOnClickListener(this);

        TextView lTextView = new TextView(this);
        lTextView.setText("J'applique un style");
        
        m_customView = new GCustomView(this);

        lMainLayout.addView(lButton);
        lMainLayout.addView(lTextView);
        lMainLayout.addView(m_customView);

        setContentView(lMainLayout);        
    }
    //===============================================
    @Override
    public void onClick(View v) {
        if(m_state == "red") {
            m_customView.setText("J'active le fond d'écran (Rouge)");
            m_customView.setBgColor("#501010");
            m_state = "green";
        }
        else if(m_state == "green") {
            m_customView.setText("J'active le fond d'écran (Vert)");
            m_customView.setBgColor("#105010");
            m_state = "blue";
        }
        else if(m_state == "blue") {
            m_customView.setText("J'active le fond d'écran (Bleu)");
            m_customView.setBgColor("#101050");
            m_state = "red";
        }
    }
    //===============================================
}
//===============================================
