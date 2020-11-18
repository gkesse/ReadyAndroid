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
//===============================================
public class GMainActivity2 extends Activity implements OnClickListener {
    //===============================================
    private String G_VIEW_ID = "ADMIN"; 
    //===============================================
    private Map<View, String> m_menuId = new HashMap<View, String>();
    private List<String> m_menuKey = new ArrayList<String>();
    private Map<String, String> m_menuName = new HashMap<String, String>();
    //===============================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {      
        super.onCreate(savedInstanceState);
        createMenuKey();
        createMenuName();
        createLayout();
        createIntent();
        
        sGAndroid lAndroid = GManager.Instance().dataGet().android;
        lAndroid.context  = this;
        GSQLiteMgr.Instance().test();
    }
    //===============================================
    @Override
    public void onClick(View v) {
        sGAndroid lAndroid = GManager.Instance().dataGet().android;

        String lMenuId = m_menuId.get(v);
        if(lMenuId == null) return;
        if(lMenuId.equals(G_VIEW_ID)) return;
        Intent lIntent = lAndroid.intent.get(lMenuId);
        if(lIntent == null) return;
        startActivity(lIntent);
        //Toast.makeText(this, lMenuId, Toast.LENGTH_SHORT).show();
    }
    //===============================================
    private void createMenuKey() {
        m_menuKey.add(G_VIEW_ID);
        m_menuKey.add("SQLITE");
        m_menuKey.add("OPENCV");
        m_menuKey.add("FILE");
    }
    //===============================================
    private void createMenuName() {
        m_menuName.put(G_VIEW_ID, G_VIEW_ID);
    }
    //===============================================
    private void createLayout() {
        LinearLayout lMainLayout = new LinearLayout(this);
        lMainLayout.setOrientation(LinearLayout.VERTICAL);
        lMainLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                
        for(int i = 0; i < m_menuKey.size(); i++) {
            String lMenuId = m_menuKey.get(0);
            String lMenuT = m_menuKey.get(i);
            Button lMenuB = new Button(this);
            String lMenuN = m_menuName.get(lMenuT);
            if(lMenuN == null) lMenuN = lMenuT;
            lMenuB.setText(lMenuN);
            lMenuB.setAllCaps(false);
            lMenuB.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            lMenuB.setOnClickListener(this);
            lMainLayout.addView(lMenuB);
            if(i != 0) {lMenuId += "." + lMenuT;}
            m_menuId.put(lMenuB, lMenuId);
        }
        
        lMainLayout.addView(GWidget.Create("titlebar", this));
        lMainLayout.addView(GWidget.Create("addressbar", this));
        setContentView(lMainLayout);
    }
    //===============================================
    private void createIntent() {
        sGAndroid lAndroid = GManager.Instance().dataGet().android;
        lAndroid.intent.put("ADMIN", getIntent()); 
        lAndroid.intent.put("ADMIN.SQLITE", new Intent(this, GSQLiteUi.class)); 
        lAndroid.intent.put("ADMIN.SQLITE.TABLES_SHOW", new Intent(this, GSQLiteTablesShowActivity.class)); 
    }
    //===============================================
}
//===============================================
