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
import java.util.*;
import org.json.*;
//===============================================
public class GMainActivity extends Activity implements OnClickListener {
    //===============================================
    private String VIEW_ID = "ADMIN"; 
    //===============================================
    private Map<View, String> m_menuId = new HashMap<View, String>();
    private List<String> m_menuL = new ArrayList<String>();
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createMenu();
        createLayout();
        createIntent();
    }
    //===============================================
    @Override
    public void onClick(View v) {
        String lMenuId = m_menuId.get(v);
        if(lMenuId == null) return;
        if(lMenuId.equals(VIEW_ID)) return;
        Intent lIntent = GManager.Instance().getIntent(lMenuId);
        if(lIntent == null) return;
        startActivity(lIntent);
        //Toast.makeText(this, lMenuId, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    private void createMenu() {
        m_menuL.add("ADMIN");
        m_menuL.add("SQLITE");
        m_menuL.add("OPENCV");
        m_menuL.add("FILE");
    }
    //===============================================
    private void createLayout() {
        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                
        for(int i = 0; i < m_menuL.size(); i++) {
            String lMenuId = m_menuL.get(0);
            String lMenuT = m_menuL.get(i);
            Button lMenuB = new Button(this);
            lMenuB.setText(lMenuT);
            lMenuB.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            lMenuB.setOnClickListener(this);
            lMainLayout.addView(lMenuB);
            if(i != 0) {lMenuId += "." + lMenuT;}
            m_menuId.put(lMenuB, lMenuId);
        }
        
        setContentView(lMainLayout);
    }
    //===============================================
    private void createIntent() {
        GManager.Instance().addIntent("ADMIN", getIntent()); 
        GManager.Instance().addIntent("ADMIN.SQLITE", new Intent(this, GSQLiteActivity.class)); 
    }
    //===============================================
}
//===============================================
